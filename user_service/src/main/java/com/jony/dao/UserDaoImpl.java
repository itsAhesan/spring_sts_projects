package com.jony.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jony.repository.UserRepository;
import com.jony.request.UserRequest;
@Component
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserRequest saveUser(UserRequest request) {
		// TODO Auto-generated method stub
		return repository.save(request);
	}

	@Override
	public UserRequest getUser(int id) {
		
		return repository.findById(id).orElse(null);
	}
	

}
