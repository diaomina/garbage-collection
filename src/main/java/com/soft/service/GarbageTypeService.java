package com.soft.service;

import java.util.List;

import com.soft.model.GarbageType;

/**
 * 
 * @ClassName: GarbageTypeService
 * @Description: 垃圾类型业务接口
 * @author: ljy
 * @date: 2019年12月13日 上午12:40:39
 */
public interface GarbageTypeService {
	
	// 根据垃圾类型名称查找
	GarbageType ByGarbageTypeName(String garbageTypeName);

	// 根据id查找
	GarbageType getById(Integer id);

	// 获取所有
	List<GarbageType> getAll();

	// 添加
	int add(GarbageType garbageType);

	// 修改
	int update(GarbageType garbageType);

	// 删除
	int delete(Integer id);

}
