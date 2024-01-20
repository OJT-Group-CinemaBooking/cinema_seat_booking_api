package com.hostmdy.cinema.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.SeatPattern;
import com.hostmdy.cinema.domain.Theater;
import java.util.List;


public interface SeatPatternRepository extends CrudRepository<SeatPattern,Long>{
	
}
