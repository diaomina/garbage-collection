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

import com.soft.model.Cart;
import com.soft.model.ChildOrder;
import com.soft.model.Goods;
import com.soft.model.Order;
import com.soft.model.User;
import com.soft.service.CartService;
import com.soft.service.ChildOrderService;
import com.soft.service.GoodsService;
import com.soft.service.OrderService;
import com.soft.util.MathUtil;

/**
 * 
 * @ClassName: CartAction
 * @Description: 购物车操作
 * @author: ljy
 * @date: 2019年12月10日 上午12:32:32
 */
@Controller
@RequestMapping("/cart")
public class CartAction {

	@Autowired
	private CartService cartService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private ChildOrderService childOrderService;
	
	@Autowired
	private OrderService orderService;
	
	

	// 跳转到购物车
	@RequestMapping("/toCart")
	public String toCart(Map<String, Object> map, HttpSession session, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		User user = (User) session.getAttribute("user");

		// 判断是否登录
		if (user == null) {
			System.out.println("您尚未登录，请先登录！");
			out.write("<script>alert('您尚未登录，请先登录！');"
					+ "window.location.href='/garbage-collection/'</script>");
			return null;
		} 
		// 获取购物车
		Cart cart = cartService.getByUserId(user.getId());
		
		double allprice = 0.0;
		// 获取购物车内商品信息
		List<ChildOrder> list = childOrderService.getByOrderIdAndType(cart.getId(), 1);
		List<Goods> goodsList = new ArrayList<Goods>();
		for(ChildOrder childOrder : list){
			Goods goods = goodsService.getById(childOrder.getGoodsid());
			goodsList.add(goods);
			allprice += goods.getPrice();
		}
		
		// 更新购物车总价
		cart.setAllprice(allprice);
		cartService.update(cart);
		
		map.put("cart", cart);
		map.put("goodsList", goodsList);
		
		return "user/cart";
	}

	// 将商品加入购物车
	@RequestMapping("/addCart")
	public void addCart(Integer id, HttpSession session, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();
		User user = (User) session.getAttribute("user");

		// 判断是否登录
		if (user == null) {
			System.out.println("您尚未登录，请先登录！");
			out.write("<script>alert('您尚未登录，请先登录！');"
					+ "window.location.href='/garbage-collection/user/toMain'</script>");
		} else {
			// 判断用户是否已经有购物车，没有则创建
			System.out.println("user=" + user);
			Integer userid = user.getId();
			System.out.println("userid=" + userid);
			Cart cart = cartService.getByUserId(userid);
			System.out.println("cart=" + cart);
			if (cart == null) {
				cart = new Cart();
				cart.setUserid(user.getId());
				cart.setAllprice(0.0);
				cartService.add(cart);
			}
			// 从数据库取出最新的购物车
			cart = cartService.getByUserId(user.getId());

			// 创建子订单（每添加一个商品到购物车都需要新建一个子订单）
			ChildOrder childOrder = new ChildOrder();
			childOrder.setGoodsid(id); // 设置商品id
			childOrder.setOrderid(cart.getId());// 设置订单id
			childOrder.setChildordertype(1);// 设置订单类型
			childOrderService.add(childOrder);

			System.out.println("添加成功！");
			out.write("<script>alert('添加成功！');" + "window.location.href='/garbage-collection/user/toMain'</script>");
		}
	}
	
	
	// 删除按钮
	@RequestMapping("/delete")
	public String delete(Integer cartId, Integer goodsId) throws IOException{
		// 在购物车中删除此商品
		childOrderService.deleteByOrderIdAndTypeAndGoodsId(cartId, 1, goodsId);
		return "redirect:toCart";
	}
	
	
	// 清空购物车
	@RequestMapping("/deleteAll")
	public String deleteAll(Integer cartId) {
		childOrderService.deleteByOrderIdAndType(cartId, 1);
		return "redirect:toCart";
	}
	
	
	// 结算
	@RequestMapping("/createOrder")
	public void createOrder(Integer cartId, HttpSession session, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		User user = (User) session.getAttribute("user");
		Cart cart = cartService.getById(cartId);
		
		// 判断购物车是否是空的
		if(cart.getAllprice() == 0.0 || cart.getAllprice() == null) {
			System.out.println("您的购物车是空的！");
			out.write("<script>alert('您的购物车是空的！');" + "window.location.href='/garbage-collection/cart/toCart'</script>");
		} else {
			// 将商品从购物车中拉出
			List<ChildOrder> list = childOrderService.getByOrderIdAndType(cartId, 1);
			List<Goods> goodsList = new ArrayList<Goods>();
			for(ChildOrder childOrder : list) {
				Goods goods = goodsService.getById(childOrder.getGoodsid());
				goodsList.add(goods);
			}
			
			// 生成8位数订单号
			Integer orderId = MathUtil.randomDigitNumber(8); 
			
			// 创建订单
			Order order = new Order();
			order.setId(orderId);
			order.setUserid(user.getId());
			order.setAllprice(cart.getAllprice());
			order.setStarttime(new Date());
			order.setStatus(1);
			orderService.add(order);
			
			// 将商品存入订单
			for(Goods goods : goodsList) {
				ChildOrder childOrder = new ChildOrder();
				childOrder.setChildordertype(2);
				childOrder.setGoodsid(goods.getId());
				childOrder.setOrderid(orderId);
				childOrderService.add(childOrder );
			}
			
			// 清空购物车
			childOrderService.deleteByOrderIdAndType(cart.getId(), 1);
			
			// 跳转到"我的订单"
			System.out.println("创建订单！");
			out.write("<script>alert('创建订单成功，前往 [ 我的订单 ] ！');" + "window.location.href='/garbage-collection/order/toMyOrders'</script>");
		}
	}
		
}