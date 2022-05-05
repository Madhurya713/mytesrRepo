package com.test.FormControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class FormControllerAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionOccurred(){
		return new ResponseEntity<String>("Something went Wrong! please try again....!!", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
