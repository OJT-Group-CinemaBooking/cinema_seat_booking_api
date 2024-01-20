package com.hostmdy.cinema.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.cinema.domain.Theater;

public interface TheaterService {
	List<Theater> getAllTheater();
	
	Theater saveTheater(Theater theater);
	
	Optional<Theater> getTheaterById(Long theaterId);
	
	void deleteTheater(Long theaterId);
}
