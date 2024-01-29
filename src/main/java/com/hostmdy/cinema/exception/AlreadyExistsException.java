package com.hostmdy.cinema.exception;

public class AlreadyExistsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8995229174769106057L;
	
	public AlreadyExistsException(String message) {
		super(message);
	}

}
