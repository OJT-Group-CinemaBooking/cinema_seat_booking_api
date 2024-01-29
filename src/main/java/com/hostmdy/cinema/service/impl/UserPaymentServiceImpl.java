package com.hostmdy.cinema.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.User;
import com.hostmdy.cinema.domain.UserPayment;
import com.hostmdy.cinema.exception.DatabaseResourceNotFoundException;
import com.hostmdy.cinema.exception.IllegalResourceAccessException;
import com.hostmdy.cinema.repository.UserPaymentRepository;
import com.hostmdy.cinema.repository.UserRepository;
import com.hostmdy.cinema.service.UserPaymentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserPaymentServiceImpl implements UserPaymentService {

	private final UserPaymentRepository userPaymentRepository;
	private final UserRepository userRepository;
	
	private User getUser(String username) {
		Optional<User> userOptional = userRepository.findByUsername(username);
		if (userOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("User", "username",
					"User with username: " + username + " is not found.");
		}
		return userOptional.get();
	}

	@Override
	public UserPayment getUserPayments(String username) {
		// TODO Auto-generated method stub
		return userPaymentRepository.findByUser(getUser(username));
	}

	@Override
	public Optional<UserPayment> getUserPaymentById(Long userPaymentId) {
		// TODO Auto-generated method stub
		return userPaymentRepository.findById(userPaymentId);
	}

	@Override
	public UserPayment saveUserPayment(UserPayment userPayment) {
		// TODO Auto-generated method stub
		return userPaymentRepository.save(userPayment);
	}

	@Override
	public UserPayment createUserPayment(UserPayment userPayment, String username) {
		// TODO Auto-generated method stub
		User user = getUser(username);
		user.setUserPayment(userPayment);
		userPayment.setUser(user);
		return saveUserPayment(userPayment);
	}

	@Override
	public UserPayment updateUserPayment(UserPayment userPayment, String username) {
		// TODO Auto-generated method stub
		User user = getUser(username);
		if(userPayment.getId() == null) {
			throw new IllegalArgumentException("userpaymentId is required");
		}
		
		if(user.getUserPayment().getId() != userPayment.getId()) {
			throw new IllegalResourceAccessException("You cant access this resource");
		}
		
		UserPayment originalUserPayment = userPaymentRepository.findById(userPayment.getId()).get();
		userPayment.setUser(originalUserPayment.getUser());
		
		return saveUserPayment(userPayment);
	}

	@Override
	public void deleteUserPaymentById(Long userPaymentId, String username) {
		// TODO Auto-generated method stub
		if(getUser(username).getUserPayment().getId() != userPaymentId) {
			throw new IllegalResourceAccessException("You cant access this resource");
		}
		userPaymentRepository.deleteById(userPaymentId);
	}

}
