package com.soft.action.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.model.Address;
import com.soft.model.ChildOrder;
import com.soft.model.Goods;
import com.soft.model.Order;
import com.soft.service.AddressService;
import com.soft.service.ChildOrderService;
import com.soft.service.GoodsService;
import com.soft.service.OrderService;
import com.soft.vo.OrderManagerVO;

/**
 * 
* @ClassName: OrderManagerAction
* @Description: 环保商城订单控制类
* @author ljy
* @date 2019年12月13日 上午10:16:32
*
 */
@Controller
@RequestMapping("/orderManager")
public class OrderManagerAction {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ChildOrderService childOrderService;
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private AddressService addressService;
	
	
	
	/**
	 * 
	* @Title: toOrderManager
	* @Description: 跳转到环保商城订单管理的界面
	* @param @param map
	* @param @return
	* @return String
	* @throws
	 */
	@RequestMapping("toOrderManager")
	public String toOrderManager(Map<String, Object> map) {
		// 获取所有的订单
		List<Order> list = orderService.getAll();
		
		// 创建装载订单信息和商品信息的vo
		List<OrderManagerVO> orderManagerVOList = new ArrayList<OrderManagerVO>();
		
		// 装载vo
		for(Order o : list){
			// 每个订单一个vo
			OrderManagerVO orderManagerVO = new OrderManagerVO();
			List<Goods> goodsList = new ArrayList<Goods>();
			
			// 获取订单的商品列表
			List<ChildOrder> childOrderList = childOrderService.getByOrderIdAndType(o.getId(), 2);
			for(ChildOrder c : childOrderList){
				Goods goods = goodsService.getById(c.getGoodsid());
				goodsList.add(goods);
			}
			
			// 获取订单地址
			Address address = addressService.getById(o.getAddressid());
			
			// 填充数据
			orderManagerVO.setId(o.getId());
			orderManagerVO.setGoodsList(goodsList);
			orderManagerVO.setAllprice(o.getAllprice());
			orderManagerVO.setAddress(address);
			orderManagerVO.setStarttime(o.getStarttime());
			orderManagerVO.setEndtime(o.getEndtime());
			orderManagerVO.setStatus(o.getStatus());
			
			orderManagerVOList.add(orderManagerVO);
		}
		
		map.put("orderManagerVOList", orderManagerVOList);
		
		return "admin/orderManager";
	}
	
	
	// 删除订单
	@RequestMapping("/delete")
	public String delete(Integer id){
		// 删除子订单
		childOrderService.deleteByOrderIdAndType(id, 2);
		// 删除订单		
		orderService.delete(id);
		return "redirect:toOrderManager";
	}
	
}
