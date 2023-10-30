package com.example.springboot.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ToDoExceptions extends RuntimeException{
	private String message;
	private HttpStatus httpStatus;
	
	public ToDoExceptions(String message, HttpStatus httpStatus) {
		super(message);
		this.message = message;
	}
}
