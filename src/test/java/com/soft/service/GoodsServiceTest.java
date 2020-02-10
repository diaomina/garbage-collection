package com.soft.service;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.soft.model.Goods;

public class GoodsServiceTest {
	
	
	private static ApplicationContext context;
	private GoodsService goodsService;
	
	@Before
	public void initConfig(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		goodsService = (GoodsService)context.getBean("goodsService");
	}


	@Test
	public void testGetByGoodsType() {
		List<Goods> goodsList = goodsService.getByGoodsType(2);
		for(Goods goods : goodsList) {
			System.out.println(goods.toString());
		}
	}

	@Test
	public void testGetById() {
		Goods goods = goodsService.getById(5);
		System.out.println(goods.toString());
	}

	@Test
	public void testGetAll() {
		List<Goods> goodsList = goodsService.getAll();
		for(Goods goods : goodsList) {
			System.out.println(goods.toString());
		}
	}

	@Test
	public void testAdd() {
		Goods goods = new Goods();
		goods.setGoodstype(2); // 1 垃圾桶 2垃圾袋
		goods.setGoodsname("2号垃圾袋");
		goods.setGoodsdesc("一个不错的垃圾袋");
		goods.setImageurl("/upload/images/22.jpg");
		goods.setPrice(8.88);// 积分
		goods.setNumber(200);	// 库存数量
		
		int recordNumber = goodsService.add(goods);
		System.out.println(recordNumber);
	}

	@Test
	public void testUpdate() {
		Goods goods = new Goods();
		goods.setId(3);
		goods.setImageurl("/upload/images/13.jpg");
		int recordNumber = goodsService.update(goods);
		System.out.println(recordNumber);
	}

	@Test
	public void testDelete() {
		int recordNumber = goodsService.delete(6);
		System.out.println(recordNumber);
	}

}
