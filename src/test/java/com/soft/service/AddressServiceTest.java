package com.soft.service;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.soft.model.Address;

public class AddressServiceTest {
	
	
	private static ApplicationContext context;
	private AddressService addressService;
	
	@Before
	public void initConfig(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		addressService = (AddressService)context.getBean("addressService");
	}


	@Test
	public void testGetByUserId() {
		List<Address> addresses = addressService.getByUserId(1);
		for(Address address : addresses) {
			System.out.println(address.toString());
		}
	}

	@Test
	public void testGetById() {
		Address address = addressService.getById(4);
		System.out.println(address.toString());
	}

	@Test
	public void testAdd() {
		Address address = new Address();
		address.setUserid(2);
		address.setName("张三");
		address.setPhone("1885964588825");
		address.setAddress("北京市一环54号");
		int recordNumber = addressService.add(address);
		System.out.println(recordNumber);
	}

	@Test
	public void testUpdate() {
		Address address = new Address();
		address.setId(4);
		address.setAddress("北京市五环888号");
		int recordNumber = addressService.update(address);
		System.out.println(recordNumber);
	}

	@Test
	public void testDelete() {
		int recordNumber = addressService.delete(3);
		System.out.println(recordNumber);
	}

}
