package com.soft.action.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.model.Admin;
import com.soft.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminAction {

	@Autowired
	private AdminService adminService;

	// 跳转到管理员登录界面
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "admin/login";
	}

	// 管理员登录
	@RequestMapping("/login")
	public void login(String username, String password, HttpServletResponse response, HttpSession session) throws IOException {
		
		System.out.println(username);
		System.out.println(password);

		PrintWriter out = response.getWriter();

		if (username != null && password != null && !"".equals(username) && !"".equals(password)) {
			Admin admin = adminService.getByUserName(username);

			// 登录校验
			if (admin != null) {
				if (!admin.getPassword().equals(password)) {
					// 保存登录信息
					session.setAttribute("admin", admin);

					System.out.println("成功登录");
					out.write(
							"<script>alert('登录成功！');" + "window.location.href='/garbage-collection/admin/toMain'</script>");

				} else {
					System.out.println("密码错误！");
					out.write(
							"<script>alert('密码错误！');" + "window.location.href='/garbage-collection/admin/toLogin'</script>");
				}
			} else {
				System.out.println("管理员不存在！");
				out.write("<script>alert('管理员不存在！');" + "window.location.href='/garbage-collection/admin/toLogin'</script>");
			}
		} else {
			System.out.println("请填入正确的字段！");
			out.write("<script>alert('请填入正确的字段！');" + "window.location.href='/garbage-collection/admin/toLogin'</script>");
		}
	}
	
	// 跳转到后台系统首页
	@RequestMapping("/toMain")
	public String toMain() {
		return "admin/main";
	}
	
	
	// 退出登录
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:toLogin";
	}
	
	
}
