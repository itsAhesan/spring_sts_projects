package com.jony.spring_boot.repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.jony.spring_boot.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	@Query("SELECT e FROM Customer e WHERE e.name = :name and e.pass= :pass ")
	Customer checkDetails(String name, String pass);

	
	  @Query("SELECT e FROM Customer e WHERE e.name = :name") 
	  Customer findByName(String name);
	  
		/*
		 * @Lock(LockModeType.PESSIMISTIC_WRITE)
		 * 
		 * @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value =
		 * "1")}) Customer findById(int id);
		 */
		 
	 

}
