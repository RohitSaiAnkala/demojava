package com.exceptions;

public class PersonNotFoundException extends Exception {
	private String message;
	public PersonNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	public PersonNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
}
