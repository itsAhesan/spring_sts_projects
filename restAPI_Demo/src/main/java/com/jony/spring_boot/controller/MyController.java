package com.jony.spring_boot.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jony.spring_boot.request.Product;
import com.jony.spring_boot.response.ProductResponse;

@RestController
public class MyController {
	
	@Autowired
	private ProductResponse response;
	
	
	@PostMapping("/product")
	public ResponseEntity<ProductResponse> product(@RequestBody Product pdt){
		
		System.out.println(pdt);
		
		response.setError(false);
		response.setMsg("Data received and response");
		response.setProducts(Arrays.asList(pdt));
		
		return new ResponseEntity<ProductResponse>(response, HttpStatus.OK);
		
		
		
	}

}
