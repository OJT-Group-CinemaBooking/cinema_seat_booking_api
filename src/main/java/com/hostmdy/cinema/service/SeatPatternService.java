package com.hostmdy.cinema.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.cinema.domain.SeatPattern;

public interface SeatPatternService {
	List<SeatPattern> getAllSeatPattern();
	
	List<SeatPattern> getAllSeatPatternByTheaterId(Long theaterId);
	
	SeatPattern saveSeatPattern(SeatPattern seatPattern);
	
	SeatPattern createSeatPattern(Long theaterId,SeatPattern seatPattern);
	
	SeatPattern updateSeatPattern(Long theaterId,SeatPattern seatPattern);
	
	Optional<SeatPattern> getSeatPatternById(Long seatPatternId);
	
	Boolean deleteSeatPatternById(Long seatPatternId);
}
