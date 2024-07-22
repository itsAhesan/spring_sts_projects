package com.jony.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	
	private LocalDateTime timestrap;
	private int status;
	private String error;
	private String message;
	private String path;
	public LocalDateTime getTimestrap() {
		return timestrap;
	}
	public void setTimestrap(LocalDateTime timestrap) {
		this.timestrap = timestrap;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	

}
