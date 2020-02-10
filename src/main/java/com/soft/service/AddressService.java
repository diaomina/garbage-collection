package com.soft.service;

import java.util.List;

import com.soft.model.Address;
import com.soft.model.Admin;

/**
 * 
 * @ClassName: AddressService
 * @Description: 地址簿的业务接口
 * @author: ljy
 * @date: 2019年12月10日 下午5:31:49
 */
public interface AddressService {

	// 根据用户id查询用户的所有地址
	List<Address> getByUserId(Integer userId);

	// 根据id查找
	Address getById(Integer id);
	
	// 查找所有
	List<Address> getAll();
	
	// 添加地址
	int add(Address address);

	// 修改地址
	int update(Address address);

	// 删除地址
	int delete(Integer id);

}
