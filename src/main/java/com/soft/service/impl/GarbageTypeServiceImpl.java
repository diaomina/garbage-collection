package com.soft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.dao.GarbageTypeMapper;
import com.soft.model.GarbageType;
import com.soft.model.GarbageTypeExample;
import com.soft.model.GarbageTypeExample.Criteria;
import com.soft.service.GarbageTypeService;

@Service("garbageTypeService")
public class GarbageTypeServiceImpl implements GarbageTypeService {
	
	@Autowired
	private GarbageTypeMapper mapper;
	
	@Override
	public GarbageType ByGarbageTypeName(String garbageTypeName) {
		GarbageTypeExample example = new GarbageTypeExample();
		Criteria criteria = example.createCriteria();
		criteria.andGarbagetypenameEqualTo(garbageTypeName);
		List<GarbageType> list = mapper.selectByExample(example);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	
	@Override
	public GarbageType getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<GarbageType> getAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public int add(GarbageType garbageType) {
		return mapper.insertSelective(garbageType);
	}

	@Override
	public int update(GarbageType garbageType) {
		return mapper.updateByPrimaryKeySelective(garbageType);
	}

	@Override
	public int delete(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

	
}
