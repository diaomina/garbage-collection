package com.soft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.dao.AdminMapper;
import com.soft.model.Admin;
import com.soft.model.AdminExample;
import com.soft.model.AdminExample.Criteria;
import com.soft.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper mapper;

	@Override
	public Admin getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public Admin getByUserName(String adminname) {
		AdminExample example = new AdminExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(adminname);
		List<Admin> admins = mapper.selectByExample(example);
		if(admins != null && admins.size() > 0) {
			return admins.get(0);
		}
		return null;
	}

	@Override
	public List<Admin> getAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public int add(Admin admin) {
		return mapper.insertSelective(admin);
	}

	@Override
	public int update(Admin admin) {
		return mapper.updateByPrimaryKeySelective(admin);
	}

	@Override
	public int delete(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}


}
