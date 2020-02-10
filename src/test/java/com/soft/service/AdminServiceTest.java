package com.soft.service;


import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.soft.model.Admin;

public class AdminServiceTest {
	
	private static ApplicationContext context;
	private AdminService adminService;
	
	@Before
	public void initConfig(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		adminService = (AdminService)context.getBean("adminService");
	}

	@Test
	public void testGetById() {
		
		Admin admin = adminService.getById(1);
		System.out.println(admin.toString());
	}

	@Test
	public void testGetByUserName() {
		
		Admin admin = adminService.getByUserName("root");
		System.out.println(admin.toString());
		
	}

	@Test
	public void testGetAll() {
		
		List<Admin> admins = adminService.getAll();
		for(Admin admin : admins) {
			System.out.println(admin.toString());
		}
	}

	@Test
	public void testAdd() {
		
		Admin admin = new Admin();
		admin.setUsername("test");
		admin.setPassword("123456");
		int recordNumber = adminService.add(admin);
		System.out.println(recordNumber);

	}

	@Test
	public void testUpdate() {
		Admin admin = new Admin();
		admin.setId(1);
		admin.setPassword("admin");
		int recordNumber = adminService.update(admin);
		System.out.println(recordNumber);
	}

	@Test
	public void testDelete() {
		int recordNumber = adminService.delete(3);
		System.out.println(recordNumber);
	}

}
