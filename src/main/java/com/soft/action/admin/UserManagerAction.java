package com.soft.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.model.User;
import com.soft.service.UserService;

/**
 * 
 * @ClassName: UserAction 
 * @Description: 会员管理的控制类
 * @author: ljy
 * @date: 2019年12月13日 上午1:16:07
 */
@Controller
@RequestMapping("userManager")
public class UserManagerAction {
	
	@Autowired
	private UserService userService;

	// 跳转到会员管理界面
	@RequestMapping("toUserManager")
	public String toUserManager(Map<String, Object> map) {
		List<User> users = userService.getAll();
		map.put("users", users);
		return "admin/userManager";
		
	}
	
	// 查询
	@RequestMapping("/search")
	public String search(String username, Map<String, Object> map, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		
		if(username != null && !"".equals(username)) {
			User user = userService.getByUserName(username);
			if(user == null) {
				System.out.println("用户不存在！");
				out.write(
						"<script>alert('用户不存在！');" + "window.location.href='/garbage-collection/userManager/toUserManager'</script>");
			} else {
				List<User> users = new ArrayList<User>();
				users.add(user);
				map.put("users", users);
				return "admin/userManager";
			}
			
		} else {
			return "redirect:toUserManager";
		}
		return "redirect:toUserManager";
	}
	
	
	// 修改
	@RequestMapping("/update")
	public String update(User user) {
		if(user !=null) {
			// 这个是更新入库的user
			User newUser = userService.getById(user.getId());
			
			if(user.getUsername() !=null && !"".equals(user.getUsername())) {
				newUser.setUsername(user.getUsername());
				System.out.println("修改了用户名");
			}
			if(user.getPassword() !=null && !"".equals(user.getPassword())) {
				newUser.setPassword(user.getPassword());
				System.out.println("修改了密码");
			}
			if(user.getMoney() !=null) {
				newUser.setMoney(user.getMoney());
				System.out.println("修改了积分");
			}
			userService.update(newUser);
		}
		return "redirect:toUserManager";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) {
		userService.delete(id);
		return "redirect:toUserManager";
	}
}
