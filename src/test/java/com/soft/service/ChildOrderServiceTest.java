package com.soft.service;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.soft.model.ChildOrder;

public class ChildOrderServiceTest {
	
	private static ApplicationContext context;
	private ChildOrderService childOrderService;
	
	@Before
	public void initConfig(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		childOrderService=(ChildOrderService)context.getBean("childOrderService");
	}

	@Test
	public void testGetByOrderIdAndIdType() {
		
		Integer orderId = 2;	// 订单id
		Integer childOrderType = 1;	// 订单类型
		
		List<ChildOrder> childOrderList = childOrderService.getByOrderIdAndType(orderId, childOrderType);
		for(ChildOrder childOrder : childOrderList) {
			System.out.println(childOrder);
		}
	}

	@Test
	public void testGetById() {
		System.out.println(childOrderService.getById(5));
	}

	@Test
	public void testGetAll() {
		List<ChildOrder> all = childOrderService.getAll();
		for(ChildOrder childOrder : all) {
			System.out.println(childOrder);
		}
	}

	@Test
	public void testAdd() {
		
		ChildOrder childOrder = new ChildOrder();
		childOrder.setOrderid(2);	// 订单id
		childOrder.setChildordertype(1);	// 订单类型(1 购物车 , 2 环保商城订单)
		childOrder.setGoodsid(3);	// 商品id
		
		int recordNumber = childOrderService.add(childOrder);
		System.out.println(recordNumber);
		
	}

	@Test
	public void testUpdate() {
		ChildOrder childOrder = new ChildOrder();
		childOrder.setId(5);
		childOrder.setGoodsid(1);
		
		int recordNumber = childOrderService.update(childOrder);
		System.out.println(recordNumber);
	}

	@Test
	public void testDelete() {
	}
	
	@Test
	public void testDeleteByOrderAndIdType() {
		Integer orderId = 2;
		Integer childOrderType = 1;
		int recordNumber = childOrderService.deleteByOrderIdAndType(orderId, childOrderType);
		System.out.println(recordNumber);
	}
	
	
	@Test
	public void testDeleteByOrderIdAndTypeAndGoodsId() {
		
		Integer orderId = 1;
		Integer childOrderType = 1;
		Integer goodsId = 2;
		
		int recordNumber = childOrderService.deleteByOrderIdAndTypeAndGoodsId(orderId, childOrderType, goodsId);
		System.out.println(recordNumber);
	}
	
	
	

}
