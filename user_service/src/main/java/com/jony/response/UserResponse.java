package com.jony.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jony.request.UserRequest;

@Component
public class UserResponse {
	
	private boolean error;
	private String message;
	private List<UserRequest> listUser;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<UserRequest> getListUser() {
		return listUser;
	}
	public void setListUser(List<UserRequest> listUser) {
		this.listUser = listUser;
	}
	@Override
	public String toString() {
		return "UserResponse [error=" + error + ", message=" + message + ", listUser=" + listUser + "]";
	}
	
	

}
