package com.hostmdy.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.User;
import com.hostmdy.cinema.exception.UserAlreadyExistsException;
import com.hostmdy.cinema.repository.UserRepository;
import com.hostmdy.cinema.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
//	private final BCryptPasswordEncoder passwordEncoder;

	@Override
	public Boolean isUsernameExists(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username).isPresent();
	}

	@Override
	public Boolean isEmailExists(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email).isPresent();
	}

	@Override
	public Optional<User> getUserById(Long userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId);
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public Optional<User> getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		if(isUsernameExists(user.getUsername())) {
			throw new UserAlreadyExistsException("username already exists");
		}
		
		if(isEmailExists(user.getEmail())) {
			throw new UserAlreadyExistsException("email already exists");
		}

//		private final BCryptPasswordEncoder passwordEncoder;
		return saveUser(user);
	}

	@Override
	public void deleteUserById(Long userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}

}