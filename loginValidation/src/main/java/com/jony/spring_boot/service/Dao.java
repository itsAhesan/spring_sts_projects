package com.jony.spring_boot.service;

import javax.persistence.LockModeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration;
import org.springframework.stereotype.Component;

import com.jony.spring_boot.entity.Customer;
import com.jony.spring_boot.repository.CustomerRepo;

@Component
public class Dao {
	
	@Autowired
	CustomerRepo cRepo;

	public Customer loginCheck(String name, String pass) {
		
		Customer details = cRepo.checkDetails(name,pass);
		
		return details;
		
		
	}

	public Customer checkUser(String name) {
		/*
		 * Customer customer = cRepo.findByName(name,LockModeType.PESSIMISTIC_WRITE);
		 * Customer customer2 = cRepo.findById(customer.getId()).orElse(null);
		 */
		Customer customer = cRepo.findByName(name);
		
	
		System.out.println(customer);
		return customer;
		
	}

	public void saveData(Customer customer) {
		cRepo.save(customer);
		
	}
	
	/*
	 * public void save(Customer customer) { cRepo.findById(customer.getId());
	 * 
	 * }
	 */
	 
	
	

}
