package com.jony.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jony.model.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer>{
	
	MyUser findByUser(String user);

}
