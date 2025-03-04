package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<String> handleMovieNotFoundException(MovieNotFoundException ex) 
    
    {
       return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
	public ResponseEntity<Object> genericException(Exception ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.OK);
	}
}
