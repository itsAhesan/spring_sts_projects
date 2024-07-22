package com.jony.request;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class UserRequest {

	@Id
	private int id;

	@NotNull(message = "name can't be null or empty")
	@NotEmpty
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserRequest [id=" + id + ", name=" + name + "]";
	}

}
