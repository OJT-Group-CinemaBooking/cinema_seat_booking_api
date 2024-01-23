package com.hostmdy.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.Cinema;
import com.hostmdy.cinema.domain.Theater;
import com.hostmdy.cinema.exception.DatabaseResourceNotFoundException;
import com.hostmdy.cinema.repository.CinemaRepository;
import com.hostmdy.cinema.repository.TheaterRepository;
import com.hostmdy.cinema.service.CinemaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService{
	private final CinemaRepository cinemaRepository;
	private final TheaterRepository theaterRepository;

	@Override
	public List<Cinema> getAllCinema() {
		// TODO Auto-generated method stub
		return (List<Cinema>) cinemaRepository.findAll();
	}

	@Override
	public Cinema saveCinema(Cinema cinema) {
		// TODO Auto-generated method stub
		return cinemaRepository.save(cinema);
	}

	@Override
	public Boolean deleteCinemaById(Long cinemaId) {
		// TODO Auto-generated method stub
		Optional<Cinema> cinemaOptional = getCinemaById(cinemaId);
		if(cinemaOptional.isEmpty()) {
			return false;
		}
		Cinema cinema = cinemaOptional.get();
		List<Theater> theaters = theaterRepository.findByCinema(cinema);
		for(Theater theater : theaters) {
			theater.setCinema(null);
		}
		cinemaRepository.deleteById(cinemaId);
		return true;
	}

	@Override
	public Optional<Cinema> getCinemaById(Long cinemaId) {
		// TODO Auto-generated method stub
		Optional<Cinema> cinemaOptional = cinemaRepository.findById(cinemaId);
		if(cinemaOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("cinema","id","id="+cinemaId+" is not found");
		}
		return cinemaOptional;
	}

	@Override
	public Cinema createCinema(Cinema cinema) {
		// TODO Auto-generated method stub
		return saveCinema(cinema);
	}

	@Override
	public Cinema updateCinema(Cinema cinema) {
		// TODO Auto-generated method stub
		return saveCinema(cinema);
	}

}
