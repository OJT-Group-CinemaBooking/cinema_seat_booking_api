package com.hostmdy.cinema.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.cinema.domain.Cinema;

public interface CinemaService {
	List<Cinema> getAllCinema();

	Cinema saveCinema(Cinema cinema);
	
	Optional<Cinema> getCinemaById(Long cinemaId);
	
	Cinema createCinema(Cinema cinema);
	
	Cinema updateCinema(Cinema cinema);
	
	Boolean deleteCinemaById(Long cinemaId);
}
