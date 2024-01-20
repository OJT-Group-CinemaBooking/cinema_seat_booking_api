package com.hostmdy.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.Theater;
import com.hostmdy.cinema.repository.TheaterRepository;
import com.hostmdy.cinema.service.TheaterService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService{
	private final TheaterRepository theaterRepository;

	@Override
	public List<Theater> getAllTheater() {
		// TODO Auto-generated method stub
		return (List<Theater>) theaterRepository.findAll();
	}

	@Override
	public Theater saveTheater(Theater theater) {
		// TODO Auto-generated method stub
		return theaterRepository.save(theater);
	}

	@Override
	public void deleteTheater(Long theaterId) {
		// TODO Auto-generated method stub
		theaterRepository.deleteById(theaterId);
	}

	@Override
	public Optional<Theater> getTheaterById(Long theaterId) {
		// TODO Auto-generated method stub
		return theaterRepository.findById(theaterId);
	}
	
	
}
