package com.soft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.dao.GarbageOrderMapper;
import com.soft.model.GarbageOrder;
import com.soft.model.GarbageOrderExample;
import com.soft.model.GarbageOrderExample.Criteria;
import com.soft.service.GarbageOrderService;

@Service("/garbageOrderService")
public class GarbageOrderServiceImpl implements GarbageOrderService {
	
	@Autowired
	private GarbageOrderMapper mapper;
	

	@Override
	public GarbageOrder getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<GarbageOrder> getByUserId(Integer userId) {
		GarbageOrderExample example = new GarbageOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		return mapper.selectByExample(example );
	}

	@Override
	public List<GarbageOrder> getAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public int add(GarbageOrder garbageOrder) {
		return mapper.insertSelective(garbageOrder);
	}

	@Override
	public int update(GarbageOrder garbageOrder) {
		return mapper.updateByPrimaryKeySelective(garbageOrder);
	}

	@Override
	public int delete(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

}
