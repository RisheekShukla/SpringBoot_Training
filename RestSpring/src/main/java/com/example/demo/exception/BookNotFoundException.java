package com.example.demo.exception;

public class BookNotFoundException extends RuntimeException 
{
	public String getMessage()
	{
		return "Unable to find a book";
	}
}
