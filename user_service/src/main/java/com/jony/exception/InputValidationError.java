package com.jony.exception;

public class InputValidationError extends RuntimeException{
	
	public InputValidationError(String message) {
		super(message);
	}

}
