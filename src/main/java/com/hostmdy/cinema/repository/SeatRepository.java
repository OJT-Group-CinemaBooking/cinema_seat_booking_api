package com.hostmdy.cinema.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.Seat;
import com.hostmdy.cinema.domain.SeatType;

public interface SeatRepository extends CrudRepository<Seat,Integer>{
	Seat findByType(SeatType type);
}
