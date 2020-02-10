package com.soft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.dao.GoodsMapper;
import com.soft.model.Goods;
import com.soft.model.GoodsExample;
import com.soft.model.GoodsExample.Criteria;
import com.soft.service.GoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	private GoodsMapper mapper;

	@Override
	public List<Goods> getByGoodsType(Integer goodstype) {
		GoodsExample example = new GoodsExample();
		Criteria criteria = example.createCriteria();
		criteria.andGoodstypeEqualTo(goodstype);
		return mapper.selectByExample(example);
	}

	@Override
	public Goods getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Goods> getAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public int add(Goods goods) {
		return mapper.insertSelective(goods);
	}

	@Override
	public int update(Goods goods) {
		return mapper.updateByPrimaryKeySelective(goods);
	}

	@Override
	public int delete(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

}
