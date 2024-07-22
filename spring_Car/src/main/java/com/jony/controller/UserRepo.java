package com.jony.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jony.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	

}
