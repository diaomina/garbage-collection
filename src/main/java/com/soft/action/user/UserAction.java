package com.soft.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soft.model.Address;
import com.soft.model.Goods;
import com.soft.model.User;
import com.soft.service.AddressService;
import com.soft.service.GoodsService;
import com.soft.service.UserService;

/**
 * 
 * @ClassName: UserAction
 * @Description: 关于user的控制器
 * @author: ljy
 * @date: 2019年12月11日 上午12:57:07
 */

@Controller
@RequestMapping("/user")
public class UserAction {

	@Autowired
	private UserService userService;

	@Autowired
	private AddressService addressService;

	@Autowired
	private GoodsService goodsService;

	// 跳转到商城首页
	@RequestMapping("/toMain")
	public String toMain(Map<String, Object> map) {
		// 获取所有商品信息
		List<Goods> list = goodsService.getAll();

		// 去除库存为0的商品
		List<Goods> goodsList = new ArrayList<Goods>();
		for (Goods goods : list) {
			if (goods.getNumber() > 0) {
				goodsList.add(goods);
			}
		}

		map.put("goodsList", goodsList);
		return "user/main";
	}

	// 首页根据商品类型查询
	@RequestMapping("/getGoodsByType")
	public String getGoodsByType(Integer goodstype, Map<String, Object> map) {
		List<Goods> goodsList = new ArrayList<Goods>();

		// 根据类型查询
		if (goodstype != 0) {
			goodsList = goodsService.getByGoodsType(goodstype);
			map.put("goodsList", goodsList);
			return "user/main";
		}
		// 查询所有
		goodsList = goodsService.getAll();
		map.put("goodsList", goodsList);

		return "user/main";
	}

	// 跳转到登录界面
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "user/login";
	}

	// 登录
	@RequestMapping("/login")
	public void login(String username, String password, HttpServletResponse response, HttpSession session)
			throws IOException {

		System.out.println(username);
		System.out.println(password);

		PrintWriter out = response.getWriter();

		if (username != null && password != null && !"".equals(username) && !"".equals(password)) {
			User user = userService.getByUserName(username);

			// 判断用户是否存在
			if (user != null) {
				if (user.getPassword().equals(password)) {
					// 将登录信息存入session
					session.setAttribute("user", user);

					System.out.println("成功登录");
					out.write("<script>alert('登录成功！');"
							+ "window.location.href='/garbage-collection/'</script>");

				} else {
					System.out.println("密码错误！");
					out.write("<script>alert('密码错误！');"
							+ "window.location.href='/garbage-collection/'</script>");
				}
			} else {
				System.out.println("用户不存在！");
				out.write(
						"<script>alert('用户不存在！');" + "window.location.href='/garbage-collection/'</script>");
			}
		} else {
			System.out.println("请填入正确的字段！");
			out.write(
					"<script>alert('请填入正确的字段！');" + "window.location.href='/garbage-collection/</script>");
		}

	}

	// 退出登录
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	// 修改密码
	@RequestMapping("/updatePassword")
	public void updatePassword(String oldPassword, String newPassword, HttpSession session,
			HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		User user = (User) session.getAttribute("user");
		
		
		// 判断是否登录
		if (user == null) {
			System.out.println("您尚未登录，请先登录！");
			out.write("<script>alert('您尚未登录，请先登录！');"
					+ "window.location.href='/garbage-collection/'</script>");
		} else {
			// 表单校验
			if(oldPassword !=null && !"".equals(oldPassword) && newPassword!=null && !"".equals(newPassword)) {
				// 判断原密码是否正确
				if(user.getPassword().equals(oldPassword)) {
					// 更新密码
					user.setPassword(newPassword);
					userService.update(user);
					// 退出登录
					session.invalidate();
					// 返回首页
					System.out.println("修改成功，请重新登录！");
					out.write("<script>alert('修改成功，请重新登录！');"
							+ "window.location.href='/garbage-collection/'</script>");
				} else {
					System.out.println("原密码输入错误！");
					out.write("<script>alert('原密码输入错误！');"
							+ "window.location.href='/garbage-collection/'</script>");
				}
			} else {
				System.out.println("请输入完整并且正确的信息！");
				out.write("<script>alert('请输入完整并且正确的信息！');"
						+ "window.location.href='/garbage-collection/'</script>");
			}
		}
	}

	// 注册
	@RequestMapping("/regist")
	public void regist(User user, Address address, HttpServletResponse response) throws IOException {

		System.out.println(user);
		System.out.println(address);
		PrintWriter out = response.getWriter();

		if (user != null && address != null) {

			// 判断用户名是否已存在
			User dbuser = userService.getByUserName(user.getUsername());
			if (dbuser != null) {
				out.write("<script>alert('用户名已存在，请重新输入！');"
						+ "window.location.href='/garbage-collection/'</script>");
			}

			user.setMoney(100.00);
			int recordNumber = userService.add(user);
			// 注册成功
			if (recordNumber == 1) {
				Integer userid = userService.getByUserName(user.getUsername()).getId();
				address.setUserid(userid);
				addressService.add(address);
				out.write("<script>alert('注册成功，系统赠送您100积分，请登录！');"
						+ "window.location.href='/garbage-collection/'</script>");
			}

		} else {
			out.write(
					"<script>alert('请输入正确的信息！');" + "window.location.href='/garbage-collection/'</script>");
		}
	}

	// 跳转到会员中心界面
	@RequestMapping("/toCenter")
	public String toCenter(Map<String, Object> map, HttpSession session, HttpServletResponse response)
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

		// 查找该用户所有地址
		List<Address> addresses = addressService.getByUserId(user.getId());
		
		// 刷新用户信息（这里实现动态刷新积分，否则需要重新登录积分才会刷新）
		user = userService.getById(user.getId());

		map.put("user", user);
		map.put("addresses", addresses);
		return "user/center";
	}

}
