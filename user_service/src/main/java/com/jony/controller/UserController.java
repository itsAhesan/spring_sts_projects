package com.jony.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jony.exception.InputValidationError;
import com.jony.exception.MethodArgumentNotValidException;
import com.jony.exception.UserNotFoundException;
import com.jony.request.UserRequest;
import com.jony.response.UserResponse;
import com.jony.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private UserResponse response;

	@PostMapping("/")
	public ResponseEntity<UserResponse> createUser(@RequestBody @Validated UserRequest request) {
		UserRequest saveUser = service.saveUser(request);
		/* throw new MethodArgumentNotValidException(" Input validation error"); */

		/*
		 * if (request.getName() == null) { throw new
		 * NullPointerException("Null value Found"); }
		 */
		if (saveUser != null) {

			response.setError(false);
			response.setMessage("User Save Successfully");
			response.setListUser(Arrays.asList(saveUser));

		}

		return ResponseEntity.ok(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable Integer id) {
		UserRequest user = service.getUser(id);
		System.out.println(id);
		System.out.println(user);

		/*
		 * if (id == null) { throw new MethodArgumentNotValidException(id +
		 * " Input validation error"); }
		 */

		if (user == null) {
			throw new InputValidationError(id + " Input validation error");
		}

		/*
		 * if (user == null) { throw new UserNotFoundException(id +
		 * " User ID Not Found"); }
		 */

		response.setError(false);
		response.setMessage("User Details");
		response.setListUser(Arrays.asList(user));
		return ResponseEntity.ok(response);

		/*
		 * if (user!=null) {
		 * 
		 * response.setError(false); response.setMessage("User Details");
		 * response.setListUser(Arrays.asList(user)); return
		 * ResponseEntity.ok(response); }else { response.setError(true);
		 * response.setMessage("User not found"); response.setListUser(null);
		 * 
		 * return new ResponseEntity<UserResponse>(response, HttpStatus.NOT_FOUND) ;
		 * 
		 * }
		 */
	}

}
