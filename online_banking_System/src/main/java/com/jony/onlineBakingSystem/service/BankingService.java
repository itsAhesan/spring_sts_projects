package com.jony.onlineBakingSystem.service;

import org.springframework.stereotype.Service;

import com.jony.onlineBakingSystem.request.BankingModel;

@Service
public interface BankingService {

	
	BankingModel registerUser(BankingModel model);

	BankingModel checkEmail(String email);

}
