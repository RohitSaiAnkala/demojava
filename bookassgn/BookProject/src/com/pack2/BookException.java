package com.pack2;

public class BookException extends Exception{
	private String message;
	public BookException(){
		
	}
	public BookException(String message) {
		super(message);
		this.message = message;
	}
	

	
}
