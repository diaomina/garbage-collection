package com.soft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.dao.AddressMapper;
import com.soft.model.Address;
import com.soft.model.AddressExample;
import com.soft.model.AddressExample.Criteria;
import com.soft.service.AddressService;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressMapper mapper;

	@Override
	public List<Address> getByUserId(Integer userId) {
		AddressExample example = new AddressExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		return mapper.selectByExample(example);
	}

	@Override
	public Address getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<Address> getAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public int add(Address address) {
		return mapper.insertSelective(address);
	}

	@Override
	public int update(Address address) {
		return mapper.updateByPrimaryKeySelective(address);
	}

	@Override
	public int delete(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	

}
