package com.hostmdy.cinema.service;

import java.util.List;

import com.hostmdy.cinema.domain.Seat;

public interface SeatService {
	List<Seat> getAllSeat();
	
	Seat saveSeat(Seat seat);
	
	void deleteSeat(Integer SeatId);
}
