package com.jony.spring_boot.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jony.spring_boot.entity.Customer;
import com.jony.spring_boot.repository.CustomerRepo;
import com.jony.spring_boot.service.Dao;

@Controller
public class MyController {

	@Autowired
	Dao dao;

	@Autowired
	CustomerRepo cRepo;

	@GetMapping("/")
	public String home() {

		return "home";
	}

	@GetMapping("loginForm")
	public String loginForm() {

		return "loginForm";

	}

	// @Scheduled(fixedRate = 12000)
	@PostMapping("loginValidation")
	public String loginValidation(@RequestParam String name, @RequestParam String pass, Model model) {
		Customer customer = dao.loginCheck(name, pass);
		Customer user = dao.checkUser(name);

		System.out.println("customer " + customer);
		System.out.println("User " + user);

		Calendar calendar = Calendar.getInstance();

		if (user != null) {
			
			/*
			 * if(user.getLockTime().before(calendar.getTime()) ) {
			 * 
			 * }
			 */

			// if(customer!=null ) {
			// if((customer!=null) && (user.getLockTime().before(calendar.getTime()))) {
			if ((customer != null) && ((user.getLockTime() == (null)) || user.getLockTime().before(calendar.getTime())) ) {

				user.setFailedAttemps(0);
				user.setLockTime(null);

				cRepo.save(user);
				model.addAttribute("name", user);
				return "loginSuccess";
			} else {
				if (user != null) {
					user.setFailedAttemps(user.getFailedAttemps() + 1);

					cRepo.save(user);

				}

				if (user.getFailedAttemps() >= 3 && user.getLockTime() == null) {

					// if(user.getFailedAttemps()>=3 &&
					// user.getLockTime().after(calendar.getTime())) {

					calendar.add(Calendar.MINUTE, 1);
					user.setLockTime(calendar.getTime());
					cRepo.save(user);

					System.out.println("Login Failed");

					return "accountLock";

				}

				if (user.getFailedAttemps() >= 3) {

					/*
					 * if (user.getLockTime().before(calendar.getTime())) { // Correct Logic
					 * user.setFailedAttemps(0); user.setLockTime(null); cRepo.save(user);
					 * System.out.println("hello"); return "unlockAccount"; }
					 */

					return "accountLocked";
				}

				return "loginFailed";

			}

		} else {

			return "loginFailed";
		}

	}
	/*
	 * private boolean lockAC(Customer c) {
	 * 
	 * if(c.getFailedAttemps()>=3) { LocalDateTime d =c.getFailedAttemps().plus(2,
	 * ChronoUnit.MINUTES); c.getFailedAttemps().plus(2, return
	 * LocalDateTime.now().isBefore(d); } return false;
	 * 
	 * 
	 * }
	 */

	@GetMapping("logout")
	public String logout() {

		return "redirect:/loginForm";

	}

	@GetMapping("registrationForm")
	public String registrationForm() {

		return "registrationForm";

	}

	@GetMapping("saveAll")
	public String saveAll(@ModelAttribute Customer customer) {
		dao.saveData(customer);

		return "save";

	}

}
