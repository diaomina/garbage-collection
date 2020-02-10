package com.soft.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.soft.model.Cart;

public class CartServiceTest {
	
	private static ApplicationContext context;
	private CartService cartService;
	
	@Before
	public void initConfig(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		cartService = (CartService)context.getBean("cartService");
	}

	@Test
	public void testGetById() {
		Cart cart = cartService.getById(1);
		System.out.println(cart);
	}

	@Test
	public void testGetByUserId() {
		Cart cart = cartService.getByUserId(1);
		System.out.println(cart);
	}

	@Test
	public void testGetAll() {
		List<Cart> carts = cartService.getAll();
		for(Cart cart : carts) {
			System.out.println(cart);
		}
	}

	@Test
	public void testAdd() {
		Cart cart = new Cart();
		cart.setUserid(1);
		cart.setAllprice(888.22);
		int recordNumber = cartService.add(cart);
		System.out.println(recordNumber);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
