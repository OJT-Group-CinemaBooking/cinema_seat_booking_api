package com.hostmdy.cinema.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.UserPayment;
import com.hostmdy.cinema.domain.User;


public interface UserPaymentRepository extends CrudRepository<UserPayment, Long> {

	UserPayment findByUser(User user);
	
}
