package com.hostmdy.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.Cinema;
import com.hostmdy.cinema.domain.Theater;
import com.hostmdy.cinema.exception.DatabaseResourceNotFoundException;
import com.hostmdy.cinema.repository.CinemaRepository;
import com.hostmdy.cinema.repository.TheaterRepository;
import com.hostmdy.cinema.service.TheaterService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService{
	
	private final TheaterRepository theaterRepository;
	private final CinemaRepository cinemaRepository;

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
		Theater theater = getTheaterById(theaterId);
		theater.setCinema(null);
		theaterRepository.save(theater);
		theaterRepository.deleteById(theaterId);
	}

	@Override
	public Theater getTheaterById(Long theaterId) {
		// TODO Auto-generated method stub
		Optional<Theater> theaterOptional = theaterRepository.findById(theaterId);
		if(theaterOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("Theater","id","Theater with id+"+theaterId+" is not found.");
		}
		return theaterOptional.get();
	}

	@Override
	public Theater createTheater(Theater theater,Long cinemaId) {
		// TODO Auto-generated method stub
		
		theater.setCinema(getCinemaById(cinemaId));
		return saveTheater(theater);
	}

	@Override
	public List<Theater> getTheaterByCinemaId(Long cinemaId) {
		// TODO Auto-generated method stub
		
		
		return theaterRepository.findByCinema(getCinemaById(cinemaId));
	}

	@Override
	public Theater updateTheater(Theater theater, Long cinemaId) {
		// TODO Auto-generated method stub
		
		theater.setCinema(getCinemaById(cinemaId));
		
		return saveTheater(theater);
	}
	
	private Cinema getCinemaById(Long cinemaId) {
		Optional<Cinema> cinemaOptional = cinemaRepository.findById(cinemaId);
		if(cinemaOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("cinema","id","cinema with id="+cinemaId+" is not found.");
		}
		return cinemaOptional.get();
	}
}
