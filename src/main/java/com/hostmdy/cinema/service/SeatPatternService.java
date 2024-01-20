package com.hostmdy.cinema.service;

import java.util.List;

import com.hostmdy.cinema.domain.SeatPattern;

public interface SeatPatternService {
	List<SeatPattern> getAllSeatPattern();
	
	SeatPattern saveSeatPattern(SeatPattern seatPattern);
}
