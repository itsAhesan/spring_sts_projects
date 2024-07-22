package com.jony.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		Demo demo = context.getBean(Demo.class);
		System.out.println(demo);
		
		Demo demo1 = context.getBean(Demo.class);
		System.out.println(demo1);
		
		
		
		
		demo.m1();
		
	}

}
