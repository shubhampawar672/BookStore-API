package com.bookStore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
// Global Exception handler for all controller
public class GlobalExceptionHandler extends Exception{
	
	
	
	//BookNotFound Exception Handler
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException ex)
	{
		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	//AuthorNotFoundException handler
	@ExceptionHandler(AuthorNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleAuthorNotFoundException(AuthorNotFoundException ex)
	{
		ErrorResponse error=new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

}
