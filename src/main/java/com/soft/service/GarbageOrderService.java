package com.soft.service;

import java.util.List;

import com.soft.model.GarbageOrder;

public interface GarbageOrderService {

	// 根据id查找
	GarbageOrder getById(Integer id);

	// 根据用户id查找
	List<GarbageOrder> getByUserId(Integer userId);

	// 获取所有
	List<GarbageOrder> getAll();

	// 添加
	int add(GarbageOrder garbageOrder);

	// 修改
	int update(GarbageOrder garbageOrder);

	// 删除
	int delete(Integer id);

}
