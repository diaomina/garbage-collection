package com.soft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.dao.OrderMapper;
import com.soft.model.Order;
import com.soft.model.OrderExample;
import com.soft.model.OrderExample.Criteria;
import com.soft.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper mapper;

	@Override
	public Order getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Order> getByUserId(Integer userId) {
		OrderExample example = new OrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		return mapper.selectByExample(example);
	}

	@Override
	public List<Order> getAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public int add(Order order) {
		return mapper.insertSelective(order);
	}

	@Override
	public int update(Order order) {
		return mapper.updateByPrimaryKeySelective(order);
	}

	@Override
	public int delete(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

}
