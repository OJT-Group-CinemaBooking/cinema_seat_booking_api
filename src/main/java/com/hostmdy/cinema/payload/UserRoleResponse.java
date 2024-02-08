package com.hostmdy.cinema.payload;

import java.util.List;

import com.hostmdy.cinema.domain.User;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor 
public class UserRoleResponse {
	
	private final User user;
	private final List<String> roles;
}
