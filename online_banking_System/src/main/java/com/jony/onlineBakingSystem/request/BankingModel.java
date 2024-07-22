package com.jony.onlineBakingSystem.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class BankingModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	// @NotEmpty(message = "Name is required")

	@NotNull(message = "name can't be null or empty")
	@NotEmpty
	private String name;

	@NotEmpty(message = "Email is required")
	@Email(message = "Email should be valid")
	@Column(unique = true)
	private String email;

	@NotEmpty(message = "Password is required")
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
