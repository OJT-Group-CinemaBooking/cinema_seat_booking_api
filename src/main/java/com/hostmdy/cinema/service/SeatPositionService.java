package com.hostmdy.cinema.service;

import java.util.List;

import com.hostmdy.cinema.domain.SeatPosition;

public interface SeatPositionService {
	List<SeatPosition> getAllSeatPosition();
	
	SeatPosition saveSeatPosition(SeatPosition seatPosition);
}
