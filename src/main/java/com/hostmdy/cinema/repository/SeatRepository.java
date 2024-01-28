package com.hostmdy.cinema.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.Seat;
import com.hostmdy.cinema.domain.SeatType;
import com.hostmdy.cinema.domain.SeatPattern;



public interface SeatRepository extends CrudRepository<Seat,Integer>{
	
	Seat findByType(SeatType type);
	
	List<Seat> findBySeatPattern(SeatPattern seatPattern);
	
}
