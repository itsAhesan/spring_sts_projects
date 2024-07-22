package com.jony.spring_boot;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringWebApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringWebApplication.class, args);
		PersonRepo repo = context.getBean(PersonRepo.class);
		
		Person per= new Person();
		
	//	per.setName("Rahat");  =======Create===
	//	per.setAge(20);
	//	repo.save(per);
		
	//	Person id = repo.findById(1).orElse(null);  //======Read=====
	//	System.out.println(id.getAge()+" "+ id.getName());
		
		List<Person> list = repo.findAll();  // ========Real ALL========
		System.out.println(list);
		
		for (Person person : list) {
			System.out.println(person);
		}
		
	//	Person p = repo.findById(2).orElse(null); //========Update===
	//	p.setName("JK");
	//	p.setAge(18);
	//	repo.save(p);
		
		
	//	repo.deleteById(2);
		
		
	}

}
