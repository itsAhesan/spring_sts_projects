package com.jony.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> resourceNotFound(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails();

		errorDetails.setTimestrap(LocalDateTime.now());
		errorDetails.setStatus(HttpStatus.NOT_FOUND.value());
		errorDetails.setError("Resource Not Found");
		errorDetails.setPath(request.getDescription(false));
		errorDetails.setMessage(ex.getMessage());

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InputValidationError.class)
	public final ResponseEntity<ErrorDetails> inputValidation(Exception ex, WebRequest request) throws Exception {
		ErrorDetails errorDetails = new ErrorDetails();

		errorDetails.setTimestrap(LocalDateTime.now());
		errorDetails.setStatus(HttpStatus.NOT_FOUND.value());
		errorDetails.setError("Input Not Found");
		errorDetails.setPath(request.getDescription(false));
		errorDetails.setMessage(ex.getMessage());

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}

	/*
	 * @ExceptionHandler(NullPointerException.class) public final
	 * ResponseEntity<ErrorDetails> nullPointer(Exception ex, WebRequest request)
	 * throws Exception { ErrorDetails errorDetails=new ErrorDetails();
	 * 
	 * errorDetails.setTimestrap(LocalDateTime.now());
	 * errorDetails.setStatus(HttpStatus.NOT_FOUND.value());
	 * errorDetails.setError("Null value");
	 * errorDetails.setPath(request.getDescription(false));
	 * errorDetails.setMessage(ex.getMessage());
	 * 
	 * 
	 * return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	 * }
	 */

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleInvalidArgument(MethodArgumentNotValidException ex) {
		Map<String, String> map = new HashMap<String, String>();

		ex.getBindingResult().getFieldErrors().forEach((fieldError) -> {
			map.put(fieldError.getField(), fieldError.getDefaultMessage());
		});
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
	}

	/*
	 * public final ResponseEntity<ErrorDetails> methodNotFound(Exception ex,
	 * WebRequest request) throws Exception { ErrorDetails errorDetails=new
	 * ErrorDetails();
	 * 
	 * errorDetails.setTimestrap(LocalDateTime.now());
	 * errorDetails.setStatus(HttpStatus.NOT_FOUND.value());
	 * errorDetails.setError("Method not Found Exception");
	 * errorDetails.setPath(request.getDescription(false));
	 * errorDetails.setMessage(ex.getMessage());
	 * 
	 * 
	 * return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	 * }
	 */
}
