package com.soft.service;

import java.util.List;

import com.soft.model.Cart;

/**
 * 
 * @ClassName: CartService
 * @Description: 购物车的业务接口
 * @author: ljy
 * @date: 2019年12月11日 上午12:30:43
 */
public interface CartService {

	// 根据id查找
	Cart getById(Integer id);

	// 根据用户id查找
	Cart getByUserId(Integer userId);

	// 获取所有
	List<Cart> getAll();

	// 添加
	int add(Cart cart);

	// 修改
	int update(Cart cart);

	// 删除
	int delete(Integer id);
}
