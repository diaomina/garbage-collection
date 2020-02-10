package com.soft.service;

import java.util.List;

import com.soft.model.Order;

/**
 * 
 * @ClassName: OrderService 
 * @Description: 环保商城订单的业务接口
 * @author: ljy
 * @date: 2019年12月10日 下午11:09:43
 */
public interface OrderService {
	
	// 根据id查找
	Order getById(Integer id);
	
	// 根据用户id查找
	List<Order> getByUserId(Integer userId);
	
	// 获取所有
	List<Order> getAll();
	
	// 添加
	int add(Order order);
	
	// 修改
	int update(Order order);
	
	// 删除
	int delete(Integer id);

}
