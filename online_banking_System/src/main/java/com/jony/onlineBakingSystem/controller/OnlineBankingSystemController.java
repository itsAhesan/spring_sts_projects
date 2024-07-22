package com.jony.onlineBakingSystem.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jony.onlineBakingSystem.request.BankingModel;
import com.jony.onlineBakingSystem.response.BankingResponse;
import com.jony.onlineBakingSystem.service.BankingService;

@RestController
@RequestMapping("/api")
public class OnlineBankingSystemController {

	@Autowired
	private BankingService service;

	@Autowired
	private BankingResponse response;

	@PostMapping("/registerUser")
	public ResponseEntity<BankingResponse> registerUser(@RequestBody @Validated BankingModel model) {

		BankingModel userEmail = service.checkEmail(model.getEmail());

		if (userEmail != null) {
			response.setError(false);
			response.setMsg("Email Already Exist");
			return new ResponseEntity<BankingResponse>(response, HttpStatus.OK);
		}

		BankingModel user = service.registerUser(model);

		if (user != null) {
			response.setError(false);
			response.setMsg("User Registered Successfully");
			response.setBankDetails(Arrays.asList(user));

			return new ResponseEntity<BankingResponse>(response, HttpStatus.OK);

		} else {
			response.setError(true);
			response.setMsg("Failed to Register");

			return new ResponseEntity<BankingResponse>(response, HttpStatus.OK);
		}

	}
	
	@PostMapping("/transferFunds")
	public ResponseEntity<BankingResponse> transferFunds(@RequestBody @Validated BankingModel model) {

		BankingModel userEmail = service.checkEmail(model.getEmail());

		if (userEmail != null) {
			response.setError(false);
			response.setMsg("Email Already Exist");
			return new ResponseEntity<BankingResponse>(response, HttpStatus.OK);
		}

		BankingModel user = service.registerUser(model);

		if (user != null) {
			response.setError(false);
			response.setMsg("User Registered Successfully");
			response.setBankDetails(Arrays.asList(user));

			return new ResponseEntity<BankingResponse>(response, HttpStatus.OK);

		} else {
			response.setError(true);
			response.setMsg("Failed to Register");

			return new ResponseEntity<BankingResponse>(response, HttpStatus.OK);
		}

	}

}
