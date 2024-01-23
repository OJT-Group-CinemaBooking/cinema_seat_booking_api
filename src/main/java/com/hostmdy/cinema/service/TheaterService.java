package com.hostmdy.cinema.service;

import java.util.List;

import com.hostmdy.cinema.domain.Theater;

public interface TheaterService {
	List<Theater> getAllTheater();
	
	List<Theater> getTheaterByCinemaId(Long cinemaId);
	
	Theater saveTheater(Theater theater);
	
	Theater getTheaterById(Long theaterId);
	
	Theater createTheater(Theater theater,Long cinemaId);
	
	Theater updateTheater(Theater theater,Long cinemaId);
	
	void deleteTheater(Long theaterId);
}
