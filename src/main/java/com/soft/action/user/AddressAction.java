package com.soft.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.model.Address;
import com.soft.service.AddressService;

/**
 * 
* @ClassName: AddressAction
* @Description: 地址控制器
* @author ljy
* @date 2019年12月12日 下午4:23:38
*
 */

@Controller
@RequestMapping("/address")
public class AddressAction {
	
	@Autowired
	private AddressService addressService;

	// 添加地址
	@RequestMapping("/add")
	public void add(Address address, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		
		// 表单校验
		if(address!=null && address.getName()!=null && address.getPhone()!=null && address.getAddress()!=null){
			
			// 判断添加结果
			if(addressService.add(address) == 1){
				System.out.println("添加成功!");
				out.write("<script>alert('添加成功！');"
						+ "window.location.href='/garbage-collection/user/toCenter'</script>");
			} else {
				System.out.println("添加失败!");
				out.write("<script>alert('添加失败！');"
						+ "window.location.href='/garbage-collection/user/toCenter'</script>");
			}
			
			
		} else {
			System.out.println("请您输入完整并正确的信息！");
			out.write("<script>alert('请您输入完整并正确的信息！');"
					+ "window.location.href='/garbage-collection/user/toCenter'</script>");
		}
	}
	
	
	//删除地址
	@RequestMapping("/delete")
	public String delete(Integer id) {
		addressService.delete(id);
		return "redirect:/user/toCenter";
	}
	
	// 修改地址
	@RequestMapping("/update")
	public String update(Integer id, String name, String phone, String address) {
		// 更新入库的地址
		Address newAddress = addressService.getById(id);
		if(name!=null && !"".equals(name)) {
			newAddress.setName(name);
		}
		if(phone!=null && !"".equals(phone)) {
			newAddress.setPhone(phone);
		}
		if(address!=null && !"".equals(address)) {
			newAddress.setAddress(address);
		}
		addressService.update(newAddress);
		
		return "redirect:/user/toCenter";
	}
	
}
