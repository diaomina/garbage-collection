package com.soft.service;

import java.util.List;

import com.soft.model.User;

/**
 * 
 * @ClassName: 用户业务接口 
 * @Description: TODO
 * @author: ljy
 * @date: 2019年12月10日 下午12:35:06
 */
public interface UserService {
	
	// 根据id查找用户
	User getById(Integer id);
	
	// 根据用户名查找用户
	User getByUserName(String username);
	
	// 获取所有用户
	List<User> getAll();
	
	// 添加用户
	int add(User user);
	
	// 修改用户
	int update(User user);
	
	// 删除用户
	int delete(Integer id);
	
	

}
