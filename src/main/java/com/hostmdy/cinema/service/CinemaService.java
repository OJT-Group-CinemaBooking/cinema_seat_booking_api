package com.hostmdy.cinema.service;

import java.util.List;

import com.hostmdy.cinema.domain.Cinema;

public interface CinemaService {
	List<Cinema> getAllCinema();
	
	Cinema saveCinama(Cinema cinema);
	
	void deleteCinemaById(Long cinemaId);
}
