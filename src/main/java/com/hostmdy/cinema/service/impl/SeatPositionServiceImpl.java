package com.hostmdy.cinema.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.SeatPosition;
import com.hostmdy.cinema.repository.SeatPositionRepository;
import com.hostmdy.cinema.service.SeatPositionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeatPositionServiceImpl implements SeatPositionService{
	
	private final SeatPositionRepository seatPositionRepository;

	@Override
	public List<SeatPosition> getAllSeatPosition() {
		// TODO Auto-generated method stub
		return (List<SeatPosition>) seatPositionRepository.findAll();
	}

	@Override
	public SeatPosition saveSeatPosition(SeatPosition seatPosition) {
		// TODO Auto-generated method stub
		return seatPositionRepository.save(seatPosition);
	}

}
