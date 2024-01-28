package com.hostmdy.cinema.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.cinema.domain.ShowTime;

public interface ShowTimeService {
	List<ShowTime> getAllShowTime();
	
	ShowTime saveShowTime(ShowTime showTime);
	
	Optional<ShowTime> getShowTimeById(Long showTimeId);
	
	List<ShowTime> getShowTimeByMovieId(Long movieId);
	
	List<ShowTime> getShowTimeByTheaterId(Long theaterId);
	
	ShowTime createShowTime(ShowTime showTime,Long theaterId,Long movieId);
	
	ShowTime updateShowTime(ShowTime showTime);
	
	Boolean deleteShowTime(Long showTimeId);
}
