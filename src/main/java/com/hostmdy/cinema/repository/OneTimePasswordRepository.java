package com.hostmdy.cinema.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.User;
import com.hostmdy.cinema.domain.security.OneTimePassword;

public interface OneTimePasswordRepository extends CrudRepository<OneTimePassword, Long>{
	List<OneTimePassword> findByUser(User user);
	
	Optional<OneTimePassword> findByCode(String code);
}