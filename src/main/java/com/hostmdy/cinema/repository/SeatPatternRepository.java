package com.hostmdy.cinema.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.SeatPattern;
import java.util.List;
import com.hostmdy.cinema.domain.Theater;



public interface SeatPatternRepository extends CrudRepository<SeatPattern,Long>{
	
	List<SeatPattern> findByTheater(Theater theater);
	
}
