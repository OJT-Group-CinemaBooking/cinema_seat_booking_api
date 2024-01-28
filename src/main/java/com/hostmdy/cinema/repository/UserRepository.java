package com.hostmdy.cinema.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
