package com.hostmdy.cinema.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.Cinema;
import com.hostmdy.cinema.repository.CinemaRepository;
import com.hostmdy.cinema.service.CinemaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService{
	private final CinemaRepository cinemaRepository;

	@Override
	public List<Cinema> getAllCinema() {
		// TODO Auto-generated method stub
		return (List<Cinema>) cinemaRepository.findAll();
	}

	@Override
	public Cinema saveCinama(Cinema cinema) {
		// TODO Auto-generated method stub
		return cinemaRepository.save(cinema);
	}

	@Override
	public void deleteCinemaById(Long cinemaId) {
		// TODO Auto-generated method stub
		cinemaRepository.deleteById(cinemaId);
	}

}
