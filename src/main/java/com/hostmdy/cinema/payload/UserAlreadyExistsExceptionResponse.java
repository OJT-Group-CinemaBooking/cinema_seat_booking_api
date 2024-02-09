package com.hostmdy.cinema.payload;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class UserAlreadyExistsExceptionResponse {
	private final String message;

	public UserAlreadyExistsExceptionResponse(String message) {
		super();
		this.message = message;
	}
}
