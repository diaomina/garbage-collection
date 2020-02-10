package com.soft.service;



import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.soft.model.User;

public class UserServiceTest {
	
	
	
	private static ApplicationContext context;
	private UserService userService;
	
	@Before
	public void initConfig(){
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService=(UserService)context.getBean("userService");
	}

	@Test
	public void testGetById() {
		
		User user = userService.getById(1);
		System.out.println(user.toString());
	}

	@Test
	public void testGetByUserName() {
		
		User user = userService.getByUserName("lisi");
		System.out.println(user.toString());
		
	}

	@Test
	public void testGetAll() {
		
		List<User> users = userService.getAll();
		for(User user : users) {
			System.out.println(user.toString());
		}
	}

	@Test
	public void testAdd() {
		
		User user = new User();
		user.setUsername("haha");
		user.setPassword("123456");
		user.setMoney(999.98);
		int recordNumber = userService.add(user);
		System.out.println(recordNumber);

	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(1);
		user.setMoney(666.66);
		int recordNumber = userService.update(user);
		System.out.println(recordNumber);
	}

	@Test
	public void testDelete() {
		int recordNumber = userService.delete(3);
		System.out.println(recordNumber);
	}

}
