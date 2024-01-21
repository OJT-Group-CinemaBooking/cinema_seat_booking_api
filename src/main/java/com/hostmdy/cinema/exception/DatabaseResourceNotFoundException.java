package com.hostmdy.cinema.exception;


public class DatabaseResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7644133262046248117L;
	
	private final String entity;
	private final String field;
	private final String message;
	
	
	public DatabaseResourceNotFoundException(String entity, String field, String message) {
		super(message);
		this.entity = entity;
		this.field = field;
		this.message = message;
	}
	
}
