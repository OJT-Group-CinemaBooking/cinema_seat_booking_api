package com.hostmdy.cinema.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.SeatPattern;


public interface SeatPatternRepository extends CrudRepository<SeatPattern,Long>{
	
}
