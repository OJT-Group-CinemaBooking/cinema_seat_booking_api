package com.hostmdy.cinema.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.Cinema;

public interface CinemaRepository extends CrudRepository<Cinema,Long>{
	
}
