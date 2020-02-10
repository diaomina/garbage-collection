package com.soft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.dao.CartMapper;
import com.soft.model.Cart;
import com.soft.model.CartExample;
import com.soft.model.CartExample.Criteria;
import com.soft.service.CartService;

@Service("cartService")
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartMapper mapper;

	@Override
	public Cart getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public Cart getByUserId(Integer userId) {
		CartExample example = new CartExample();
		Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userId);
		List<Cart> list = mapper.selectByExample(example);
		if(list != null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Cart> getAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public int add(Cart cart) {
		return mapper.insertSelective(cart);
	}

	@Override
	public int update(Cart cart) {
		return mapper.updateByPrimaryKeySelective(cart);
	}

	@Override
	public int delete(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

}
