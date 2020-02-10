package com.soft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.dao.UserMapper;
import com.soft.model.User;
import com.soft.model.UserExample;
import com.soft.model.UserExample.Criteria;
import com.soft.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;

	@Override
	public User getById(Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public User getByUserName(String username) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> users = mapper.selectByExample(example);
		System.out.println(users);
		if(users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public int add(User user) {
		return mapper.insertSelective(user);
	}

	@Override
	public int update(User user) {
		return mapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public int delete(Integer id) {
		return mapper.deleteByPrimaryKey(id);
	}

}
