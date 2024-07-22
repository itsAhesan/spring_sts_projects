package com.jony.spring_boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Demo {
	
	@Autowired
	Demo1 d2;
	
	public void m1() {
		System.out.println("M1 Method...");
		d2.m2();
	}

}
