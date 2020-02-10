package com.soft.action.admin;

import java.nio.channels.GatheringByteChannel;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.model.Address;
import com.soft.model.GarbageOrder;
import com.soft.model.GarbageType;
import com.soft.model.User;
import com.soft.service.AddressService;
import com.soft.service.GarbageOrderService;
import com.soft.service.GarbageTypeService;
import com.soft.service.UserService;

@Controller
@RequestMapping("/garbageOrderManager")
public class GarbageOrderManagerAction {

	@Autowired
	private GarbageOrderService garbageOrderService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private GarbageTypeService garbageTypeService;
	
	@Autowired
	private UserService userService;
	
	
	
	// 跳转到垃圾回收订单管理界面
	@RequestMapping("/toGarbageOrderManager")
	public String toGarbageOrderManager(Map<String, Object> map) {
		List<GarbageOrder> garbageOrderList = garbageOrderService.getAll();
		List<GarbageType> garbageTypeList = garbageTypeService.getAll();
		List<Address> addresses = addressService.getAll();
		
		map.put("garbageOrderList", garbageOrderList);
		map.put("addresses", addresses);
		map.put("garbageTypeList", garbageTypeList);
		
		return "admin/garbageOrderManager";
	}
	
	// 删除
	@RequestMapping("/delete")
	public String delete(Integer id){
		garbageOrderService.delete(id);
		return "redirect:toGarbageOrderManager";
	}
	
	// 成功取货
	@RequestMapping("/update")
	public String update(Integer garbageOrderId, Double money) {
		
		GarbageOrder garbageOrder = garbageOrderService.getById(garbageOrderId);
		
		// 更新订单
		garbageOrder.setMoney(money);
		garbageOrder.setEndtime(new Date());
		garbageOrder.setStatus(2);
		garbageOrderService.update(garbageOrder);
		
		// 给用户充值积分
		User user = userService.getById(garbageOrder.getUserid());
		user.setMoney(money + user.getMoney());
		userService.update(user);
		
		return "redirect:toGarbageOrderManager";
	}
	
}
