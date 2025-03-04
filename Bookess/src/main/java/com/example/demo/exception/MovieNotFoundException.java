package com.example.demo.exception;

public class MovieNotFoundException extends RuntimeException {
	public String getMessage()
	{
		return "Unable to find movie";
	}
}
