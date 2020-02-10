package com.soft.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.model.Address;
import com.soft.model.ChildOrder;
import com.soft.model.Goods;
import com.soft.model.Order;
import com.soft.model.User;
import com.soft.service.AddressService;
import com.soft.service.ChildOrderService;
import com.soft.service.GoodsService;
import com.soft.service.OrderService;
import com.soft.service.UserService;

/**
 * 
 * @ClassName: OrderAction
 * @Description: 用户订单操作
 * @author: ljy
 * @date: 2019年12月10日 上午12:26:33
 */
@Controller
@RequestMapping("/order")
public class OrderAction {
	
	@Autowired
	private ChildOrderService childOrderService;

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private GoodsService goodsService;

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private UserService userService;

	// 跳转到 我的订单
	@RequestMapping("/toMyOrders")
	public String toMyOrders(Map<String, Object> map, HttpSession session, HttpServletResponse response)
			throws IOException {

		PrintWriter out = response.getWriter();
		User user = (User) session.getAttribute("user");

		// 判断是否登录
		if (user == null) {
			System.out.println("您尚未登录，请先登录！");
			out.write("<script>alert('您尚未登录，请先登录！');"
					+ "window.location.href='/garbage-collection/'</script>");
			return null;
		}

		// 获该用户地址簿
		List<Address> addresses = addressService.getByUserId(user.getId());

		// 获取该用户所有订单
		List<Order> orders = orderService.getByUserId(user.getId());

		// 根据订单状态拆分订单列表
		List<Order> orders1 = new ArrayList<Order>(); // 待支付订单
		List<Order> orders2 = new ArrayList<Order>(); // 待收货订单
		List<Order> orders3 = new ArrayList<Order>(); // 已完成订单
		for (Order order : orders) {
			if (order.getStatus() == 1) {
				orders1.add(order);
			}
			if (order.getStatus() == 2) {
				orders2.add(order);
			}
			if (order.getStatus() == 3) {
				orders3.add(order);
			}
		}

		map.put("orders1", orders1);
		map.put("orders2", orders2);
		map.put("orders3", orders3);
		map.put("addresses", addresses);

		return "user/myOrders";
	}
	
	// 删除订单
	@RequestMapping("/delete")
	public String delete(Integer orderId){
		// 删除子订单
		childOrderService.deleteByOrderIdAndType(orderId, 2);
		// 删除订单
		orderService.delete(orderId);
		// 重定向到“我的订单”
		return "redirect:toMyOrders";
	}

	// 付款
	@RequestMapping("/pay")
	public void pay(Integer orderId,Integer addressId, HttpSession session, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		User user = (User) session.getAttribute("user");
		Order order = orderService.getById(orderId);
		
		double allprice = order.getAllprice();
		
		// 查询可用积分是否充足
		if (user.getMoney() < allprice) {
			System.out.println("您的积分不足！");
			out.write("<script>alert('您的积分不足！');" + "window.location.href='/garbage-collection/order/toMyOrders'</script>");
		} else {
			// 更新积分
			user.setMoney(user.getMoney() - allprice);
			userService.update(user);
			//更新收货地址、订单状态
			order.setStatus(2);
			order.setAddressid(addressId);
			orderService.update(order);
			//更新商品库存数量
			List<ChildOrder> list = childOrderService.getByOrderIdAndType(orderId, 2);
			for(ChildOrder childOrder : list) {
				Goods goods = goodsService.getById(childOrder.getGoodsid());
				goods.setNumber(goods.getNumber() - 1);
				goodsService.update(goods);
			}
			
			// 跳转
			System.out.println("支付成功！");
			out.write("<script>alert('支付成功！扣除"+(allprice+"")+"积分!');" + "window.location.href='/garbage-collection/order/toMyOrders'</script>");
		}
	}
	
	// 确认收货
	@RequestMapping("/receive")
	public String receive(Integer orderId) {
		Order order = orderService.getById(orderId);
		order.setEndtime(new Date());
		order.setStatus(3);
		orderService.update(order);
		return "redirect:toMyOrders";
	}
	

}
