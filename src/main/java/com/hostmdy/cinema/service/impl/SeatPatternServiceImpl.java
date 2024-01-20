package com.hostmdy.cinema.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.SeatPattern;
import com.hostmdy.cinema.repository.SeatPatternRepository;
import com.hostmdy.cinema.service.SeatPatternService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeatPatternServiceImpl implements SeatPatternService{
	
	private final SeatPatternRepository seatPatternRepository;

	@Override
	public List<SeatPattern> getAllSeatPattern() {
		// TODO Auto-generated method stub
		return (List<SeatPattern>) seatPatternRepository.findAll();
	}

	@Override
	public SeatPattern saveSeatPattern(SeatPattern seatPattern) {
		// TODO Auto-generated method stub
		return seatPatternRepository.save(seatPattern);
	}

}
