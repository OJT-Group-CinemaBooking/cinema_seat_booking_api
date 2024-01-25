package com.hostmdy.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.Movie;
import com.hostmdy.cinema.domain.ShowTime;
import com.hostmdy.cinema.domain.Theater;
import com.hostmdy.cinema.exception.DatabaseResourceNotFoundException;
import com.hostmdy.cinema.repository.MovieRepository;
import com.hostmdy.cinema.repository.ShowTimeRepository;
import com.hostmdy.cinema.repository.TheaterRepository;
import com.hostmdy.cinema.service.ShowTimeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShowTimeServiceImpl implements ShowTimeService{
	
	private final ShowTimeRepository showTimeRepository;
	private final TheaterRepository theaterRepository;
	private final MovieRepository movieRepository;
	
	private Movie getShowtimeByMovieId(Long movieId) {
		Optional<Movie> movieOptional = movieRepository.findById(movieId);
		if(movieOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("showtime","movieId","showtime with movieId ="+movieId+" is not found.");
		}
		return movieOptional.get();
	}
	
	private Theater getShowtimeByTheaterId(Long theaterId) {
		Optional<Theater> theaterOptional = theaterRepository.findById(theaterId);
		if(theaterOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("showtime","theaterid","showtime with theaterId ="+theaterId+" is not found.");
		}
		return theaterOptional.get();
	}

	@Override
	public List<ShowTime> getAllShowTime() {
		// TODO Auto-generated method stub
		return (List<ShowTime>) showTimeRepository.findAll();
	}

	@Override
	public ShowTime saveShowTime(ShowTime showTime) {
		// TODO Auto-generated method stub
		return showTimeRepository.save(showTime);
	}

	@Override
	public Boolean deleteShowTime(Long showTimeId) {
		// TODO Auto-generated method stub
		Optional<ShowTime> showtimeOptional = showTimeRepository.findById(showTimeId);
		if(showtimeOptional.isEmpty()) {
			return false;
		}
		showTimeRepository.deleteById(showTimeId);
		return true;
	}

	@Override
	public ShowTime createShowTime(ShowTime showTime, Long theaterId, Long movieId) {
		// TODO Auto-generated method stub
		showTime.setTheater(getShowtimeByTheaterId(theaterId));
		showTime.setMovie(getShowtimeByMovieId(movieId));
		
		return saveShowTime(showTime);
	}


	@Override
	public Optional<ShowTime> getShowTimeById(Long showTimeId) {
		// TODO Auto-generated method stub
		return showTimeRepository.findById(showTimeId);
	}

	@Override
	public List<ShowTime> getShowTimeByMovieId(Long movieId) {
		// TODO Auto-generated method stub
		return showTimeRepository.findByMovie(getShowtimeByMovieId(movieId));
	}

	@Override
	public List<ShowTime> getShowTimeByTheaterId(Long theaterId) {
		// TODO Auto-generated method stub
		return showTimeRepository.findByTheater(getShowtimeByTheaterId(theaterId));
	}

	@Override
	public ShowTime updateShowTime(ShowTime showTime) {
		// TODO Auto-generated method stub
		Optional<ShowTime> showTimeOptional = showTimeRepository.findById(showTime.getId());
		if(showTimeOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("showtime", "showtimeId", "showtime with id = "+showTime.getId()+" is not found.");
		}
		ShowTime showtime = showTimeOptional.get();
		showTime.setMovie(showtime.getMovie());
		showTime.setTheater(showtime.getTheater());
		return saveShowTime(showTime);
	}

}
