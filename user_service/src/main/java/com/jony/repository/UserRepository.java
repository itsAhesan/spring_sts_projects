package com.jony.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jony.request.UserRequest;

public interface UserRepository extends JpaRepository<UserRequest, Integer>{

}
