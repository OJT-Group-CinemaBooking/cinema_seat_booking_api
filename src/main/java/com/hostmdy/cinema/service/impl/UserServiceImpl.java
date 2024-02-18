package com.hostmdy.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostmdy.cinema.domain.User;
import com.hostmdy.cinema.domain.security.Role;
import com.hostmdy.cinema.domain.security.UserRoles;
import com.hostmdy.cinema.exception.DatabaseResourceNotFoundException;
import com.hostmdy.cinema.repository.RoleRepository;
import com.hostmdy.cinema.repository.UserRepository;
import com.hostmdy.cinema.service.OTPService;
import com.hostmdy.cinema.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	private final OTPService otpService;
	
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
	@Transactional
	public User createUser(User user) {
		// TODO Auto-generated method stub
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		Optional<Role> roleOptional = roleRepository.findByName("ROLE_USER");
		
		if(roleOptional.isEmpty()) {
			throw new NullPointerException("ROLE_USER is not found");
		}
		
		Role role = roleOptional.get();
		UserRoles userRoles = new UserRoles(user, role);
		user.getUserRoles().add(userRoles);
		role.getUserRoles().add(userRoles);
		
		User createdUser = saveUser(user);
		otpService.createOTP(createdUser.getUsername());
		
		return createdUser;
	}

	@Override
	public void deleteUserById(Long userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		Optional<User> userOptional = userRepository.findById(user.getId());
		
		if(userOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("user","Id","userwith id "+ user.getId()+" is not found");
		}
		
		User previousUser = userOptional.get();
		
		previousUser.setFirstname(user.getFirstname());
		previousUser.setLastname(user.getLastname());
		previousUser.setEmail(user.getEmail());
		
		
		return saveUser(previousUser);
	}

}
