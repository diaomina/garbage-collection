package com.soft.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.soft.model.GarbageOrder;
import com.soft.model.GarbageType;
import com.soft.model.User;
import com.soft.service.AddressService;
import com.soft.service.GarbageOrderService;
import com.soft.service.GarbageTypeService;

/**
 * 
* @ClassName: GarbageOrderAction
* @Description: 垃圾回收订单控制类
* @author ljy
* @date 2019年12月13日 上午11:53:04
*
 */
@Controller
@RequestMapping("/garbageOrder")
public class GarbageOrderAction {
	
	@Autowired
	private GarbageOrderService garbageOrderService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private GarbageTypeService garbageTypeService;
	
	// 跳转到预约上门回收界面
	@RequestMapping("/toRetrieve")
	public String toRetrieve(Map<String, Object> map, HttpSession session, HttpServletResponse response) throws IOException{
		
		PrintWriter out = response.getWriter();
		User user = (User) session.getAttribute("user");

		// 判断是否登录
		if (user == null) {
			System.out.println("您尚未登录，请先登录！");
			out.write("<script>alert('您尚未登录，请先登录！');"
					+ "window.location.href='/garbage-collection/'</script>");
			return null;
		}
		
		List<GarbageType> garbageTypeList = garbageTypeService.getAll();
		List<Address> addresses = addressService.getByUserId(user.getId());
		
		map.put("addresses", addresses);
		map.put("garbageTypeList", garbageTypeList);
		
		return "user/retrieve";
	}
	
	// 预约上门回收
	@RequestMapping("/retrieve")
	public void retrieve(Integer userid, Integer addressid, String garbagename, Integer garbagetypeid, 
			Double weight, String appointmenttime, HttpServletResponse response) throws ParseException, IOException {
		PrintWriter out = response.getWriter();
		
		// 表单校验
		if(userid!=null && addressid!=null && garbagename!=null && garbagetypeid!=null && weight!=null 
				&& appointmenttime!=null && !"".equals(garbagename) && !"".equals(appointmenttime)) {
			// 时间处理
			appointmenttime = appointmenttime.substring(0, 10)+" "+appointmenttime.substring(11)+":00";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			// 封装
			GarbageOrder garbageOrder = new GarbageOrder();
			garbageOrder.setUserid(userid);
			garbageOrder.setAddressid(addressid);
			garbageOrder.setGarbagename(garbagename);
			garbageOrder.setGarbagetypeid(garbagetypeid);
			garbageOrder.setWeight(weight);
			garbageOrder.setAppointmenttime(simpleDateFormat.parse(appointmenttime));
			garbageOrder.setStarttime(new Date());
			garbageOrder.setStatus(1);
			// 添加垃圾上门回收订单
			if(garbageOrderService.add(garbageOrder) == 1) {
				System.out.println("预约成功！");
				out.write("<script>alert('预约成功！');"
						+ "window.location.href='/garbage-collection/garbageOrder/toRetrieve'</script>");
			} else {
				System.out.println("预约失败！");
				out.write("<script>alert('预约失败！');"
						+ "window.location.href='/garbage-collection/garbageOrder/toRetrieve'</script>");
			}
		} else {
			System.out.println("请输入完整并且正确的信息！");
			out.write("<script>alert('请输入完整并且正确的信息！');"
					+ "window.location.href='/garbage-collection/garbageOrder/toRetrieve'</script>");
		}
	}
	
	
	// 跳转到回收订单界面
	@RequestMapping("/toGarbageOrder")
	public String toGarbageOrder(Map<String, Object> map, HttpSession session, 
			HttpServletResponse response) throws IOException{
		
		PrintWriter out = response.getWriter();
		User user = (User) session.getAttribute("user");

		// 判断是否登录
		if (user == null) {
			System.out.println("您尚未登录，请先登录！");
			out.write("<script>alert('您尚未登录，请先登录！');"
					+ "window.location.href='/garbage-collection/'</script>");
			return null;
		}
		
		// 获取该用户全部订单
		List<GarbageOrder> garbageOrderList = garbageOrderService.getByUserId(user.getId());
		//拆分订单
		List<GarbageOrder> garbageOrderList1 = new ArrayList<GarbageOrder>();	//待上门订单
		List<GarbageOrder> garbageOrderList2 = new ArrayList<GarbageOrder>();	//已完成订单
		
		for(GarbageOrder garbageOrder : garbageOrderList) {
			if(garbageOrder.getStatus() == 1) {
				garbageOrderList1.add(garbageOrder);
			}
			if(garbageOrder.getStatus() == 2) {
				garbageOrderList2.add(garbageOrder);
			}
		}
		
		List<Address> addresses = addressService.getByUserId(user.getId());
		List<GarbageType> garbageTypeList = garbageTypeService.getAll();
		
		map.put("garbageOrderList1", garbageOrderList1);
		map.put("garbageOrderList2", garbageOrderList2);
		map.put("addresses", addresses);
		map.put("garbageTypeList", garbageTypeList);
		
		return "user/garbageOrder";
	}
	
	
	// 取消预约
	@RequestMapping("/delete")
	public String delete(Integer id){
		garbageOrderService.delete(id);
		return "redirect:toGarbageOrder";
	}

}
