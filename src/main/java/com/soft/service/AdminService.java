package com.soft.service;

import java.util.List;

import com.soft.model.Admin;
import com.soft.model.User;

/**
 * 
 * @ClassName: AdminService 
 * @Description: 管理员业务接口
 * @author: ljy
 * @date: 2019年12月10日 下午12:39:39
 */
public interface AdminService {
	
	// 根据id查找管理员
	Admin getById(Integer id);
	
	// 根据用户名查找管理员
	Admin getByUserName(String username);
	
	// 获取所有管理员
	List<Admin> getAll();
	
	// 添加管理员
	int add(Admin admin);
	
	// 修改管理员
	int update(Admin admin);
	
	// 删除管理员
	int delete(Integer id);
	
	

}
