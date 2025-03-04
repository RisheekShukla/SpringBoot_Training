package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Object> exceptionhandling(BookNotFoundException ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> genericException(Exception ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.OK);
	}
}
