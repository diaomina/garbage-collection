package com.soft.service;


import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.soft.model.Order;
import com.soft.util.MathUtil;

public class OrderServiceTest {
	
	
	private static ApplicationContext context;
	private OrderService orderService;
	
	@Before
	public void initConfig(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		orderService = (OrderService)context.getBean("orderService");
	}

	@Test
	public void testGetById() {
		Order order = orderService.getById(2);
		System.out.println(order);
	}

	@Test
	public void testGetByUserId() {
		List<Order> orderList = orderService.getByUserId(2);
		for(Order order : orderList) {
			System.out.println(order.toString());
		}
	}

	@Test
	public void testGetAll() {
		
		List<Order> orderList = orderService.getAll();
		for(Order order : orderList) {
			System.out.println(order.toString());
		}
	}

	@Test
	public void testAdd() {
		
		Integer orderId = MathUtil.randomDigitNumber(8); 
		System.out.println(orderId);
		
		Order order = new Order();
		order.setId(orderId);
		order.setUserid(2);
		order.setAddressid(3);
		order.setAllprice(5656.00);
		order.setStarttime(new Date());
		order.setEndtime(new Date());
		order.setStatus(1);
		
		int recordNumber = orderService.add(order);
		System.out.println(recordNumber);
		
		
	}

	@Test
	public void testUpdate() {
		Order order = new Order();
		order.setId(2);
		order.setStatus(2);
		
		int recordNumber = orderService.update(order);
		System.out.println(recordNumber);
	}

	@Test
	public void testDelete() {
		int recordNumber = orderService.delete(1);
		System.out.println(recordNumber);
	}

}
