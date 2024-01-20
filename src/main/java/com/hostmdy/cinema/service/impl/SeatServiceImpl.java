package com.hostmdy.cinema.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.Seat;
import com.hostmdy.cinema.repository.SeatRepository;
import com.hostmdy.cinema.service.SeatService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService{
	
	private final SeatRepository seatRepository;

	@Override
	public List<Seat> getAllSeat() {
		// TODO Auto-generated method stub
		return (List<Seat>) seatRepository.findAll();
	}

	@Override
	public Seat saveSeat(Seat seat) {
		// TODO Auto-generated method stub
		return seatRepository.save(seat);
	}

	@Override
	public void deleteSeat(Integer SeatId) {
		// TODO Auto-generated method stub
		seatRepository.deleteById(SeatId);
	}
	
	

}
