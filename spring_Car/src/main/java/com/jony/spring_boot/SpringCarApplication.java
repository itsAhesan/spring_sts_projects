package com.jony.spring_boot;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.jony.controller.UserRepo;
import com.jony.model.User;

@SpringBootApplication
@ComponentScan(basePackages = {"com.jony.controller","com.jony.model"})
public class SpringCarApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringCarApplication.class, args);
		UserRepo userRepo = context.getBean(UserRepo.class);
		
		User user= new User();
		
		  user.setName("Arun");
		  user.setAge(24);
		  userRepo.save(user);  // ========CREATE=======
		 
		
		// ========READ=======
		//	 User u = userRepo.findById(1).orElse(null); 
		//	System.out.println(u.getName());
		
		// ========UPDATE=======
	//	User u = userRepo.findById(2).orElse(null);
	//	u.setName("Arun");
	//	userRepo.save(u);
		
		// ========DELETE=======
	//	userRepo.deleteById(2);
		
	}

}
