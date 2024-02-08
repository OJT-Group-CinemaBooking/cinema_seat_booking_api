package com.hostmdy.cinema.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class InvalidLoginResponse {
	private String username = "username is invalid";
	private String password = "password is invalid";
}
