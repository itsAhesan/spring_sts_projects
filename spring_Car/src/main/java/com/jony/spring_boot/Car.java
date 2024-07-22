package com.jony.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	@Autowired
	Engine eng;
	
	public void drive() {
		eng.start();
		
		
		System.out.println("I can Drive..");
	}
	

}
