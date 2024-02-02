package com.hostmdy.cinema.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.BoughtSeat;
import com.hostmdy.cinema.repository.BoughtSeatRepository;
import com.hostmdy.cinema.service.BoughtSeatService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoughtSeatServiceImpl implements BoughtSeatService{
	
	private final BoughtSeatRepository boughtSeatRepository;

	@Override
	public BoughtSeat saveBoughtSeat(BoughtSeat boughtSeat) {
		// TODO Auto-generated method stub
		return boughtSeatRepository.save(boughtSeat);
	}

	@Override
	public List<BoughtSeat> getAllBoughtSeat() {
		// TODO Auto-generated method stub
		return (List<BoughtSeat>) boughtSeatRepository.findAll();
	}

}
