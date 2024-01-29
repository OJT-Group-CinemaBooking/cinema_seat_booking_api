package com.hostmdy.cinema.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.cinema.domain.User;

public interface UserService {
	
	Boolean isUsernameExists(String username);
	
	Boolean isEmailExists(String email);
	
	Optional<User> getUserById(Long userId);
	
	Optional<User> getUserByEmail(String email);
	
	Optional<User> getUserByUsername(String username);
	
	List<User> getAllUsers();
	
	User saveUser(User user);
	
	User createUser(User user);
	
	void deleteUserById(Long userId);

}
