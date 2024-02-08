package com.hostmdy.cinema.service.impl;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.User;
import com.hostmdy.cinema.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserSecurityService implements UserDetailsService{
	
	private final UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		boolean isEmail = false;
		
		if(username.contains("@") && username.contains(".")) {
			isEmail = true;
		}
		
		Optional<User> userOptional = isEmail ? userRepository.findByEmail(username) : userRepository.findByUsername(username);
		
		if(userOptional.isEmpty()) {
			log.info("email = {} is not found",username);
			
			throw new UsernameNotFoundException("user with email="+username+" is not found");
		}
		
		return userOptional.get();
	}
	
	
	public User loadUserById(Long userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		
		if(userOptional.isEmpty()) {
			log.info("userId = {} is not found",userId);
			
			throw new UsernameNotFoundException("user with id="+userId+" is not found");
		}
		
		return userOptional.get();
	}

}
