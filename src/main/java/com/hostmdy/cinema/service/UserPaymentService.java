package com.hostmdy.cinema.service;

import java.util.Optional;

import com.hostmdy.cinema.domain.UserPayment;

public interface UserPaymentService {

	UserPayment getUserPayments(String username);

	Optional<UserPayment> getUserPaymentById(Long userPaymentId);

	UserPayment saveUserPayment(UserPayment userPayment);

	UserPayment createUserPayment(UserPayment userPayment, String username);

	UserPayment updateUserPayment(UserPayment userPayment, String username);

	void deleteUserPaymentById(Long userPaymentId, String username);

}
