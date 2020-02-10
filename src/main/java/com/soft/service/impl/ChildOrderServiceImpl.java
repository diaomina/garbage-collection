package com.soft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.dao.ChildOrderMapper;
import com.soft.model.ChildOrder;
import com.soft.model.ChildOrderExample;
import com.soft.model.ChildOrderExample.Criteria;
import com.soft.service.ChildOrderService;

@Service("childOrderService")
public class ChildOrderServiceImpl implements ChildOrderService {
	
	@Autowired
	private ChildOrderMapper mapper;

	@Override
	public List<ChildOrder> getByOrderIdAndType(Integer orderId, Integer childOrderType) {
		ChildOrderExample example = new ChildOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderidEqualTo(orderId);
		criteria.andChildordertypeEqualTo(childOrderType);
		return mapper.selectByExample(example);
	}

	@Override
	public ChildOrder getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ChildOrder> getAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public int add(ChildOrder childOrder) {
		return mapper.insertSelective(childOrder);
	}

	@Override
	public int update(ChildOrder childOrder) {
		return mapper.updateByPrimaryKeySelective(childOrder);
	}

	@Override
	public int delete(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}
	
	
	@Override
	public int deleteByOrderIdAndType(Integer orderId, Integer childOrderType) {
		ChildOrderExample example = new ChildOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderidEqualTo(orderId);
		criteria.andChildordertypeEqualTo(childOrderType);
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByOrderIdAndTypeAndGoodsId(Integer orderId, Integer childOrderType, Integer goodsId) {
		ChildOrderExample example = new ChildOrderExample();
		Criteria criteria = example.createCriteria();
		criteria.andOrderidEqualTo(orderId);
		criteria.andChildordertypeEqualTo(childOrderType);
		criteria.andGoodsidEqualTo(goodsId);
		return mapper.deleteByExample(example);
	}



}
