package com.jony.onlineBakingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.jony.onlineBakingSystem.repository.BankingRepository;
import com.jony.onlineBakingSystem.request.BankingModel;

@Component
public class BankingServiceImpl implements BankingService {
	
	@Autowired
	private BankingRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;


	@Override
	public BankingModel registerUser(BankingModel model) {
		
		model.setPassword(passwordEncoder.encode(model.getPassword()));
		return repo.save(model);
	}


	@Override
	public BankingModel checkEmail(String email) {
	
		
		
		return repo.checkEmail(email);
	}

}
