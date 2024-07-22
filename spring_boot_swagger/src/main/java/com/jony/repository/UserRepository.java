package com.jony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jony.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
