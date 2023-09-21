package com.bookStore.exception;

public class AuthorNotFoundException extends RuntimeException{
	
	public AuthorNotFoundException(String msg)
	{
		super(msg);
	}
	public AuthorNotFoundException()
	{
		super();
	}
}
