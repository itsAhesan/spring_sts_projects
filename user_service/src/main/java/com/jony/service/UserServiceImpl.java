package com.jony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jony.dao.UserDao;
import com.jony.request.UserRequest;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;

	@Override
	public UserRequest saveUser(UserRequest request) {
		
		return dao.saveUser(request);
	}

	@Override
	public UserRequest getUser(int id) {
		
		return dao.getUser(id);
	}

}
