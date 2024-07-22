package com.jony.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jony.spring_boot.model.Email;

public interface EmailRepo extends JpaRepository<Email, Integer>{

	
	/*
	 * @Query("SELECT e FROM Email e WHERE e.from = :from") Email findByName(String
	 * from);
	 */

}
