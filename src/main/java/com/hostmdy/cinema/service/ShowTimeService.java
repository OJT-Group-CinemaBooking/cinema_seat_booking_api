package com.hostmdy.cinema.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.cinema.domain.ShowTime;

public interface ShowTimeService {
	List<ShowTime> getAllShowTime();
	
	Optional<ShowTime> getShowTimeById(Long showTimeId);
	
	ShowTime saveShowTime(ShowTime showTime);
	
	ShowTime createShowTime(ShowTime showTime,Long theaterId);
	
	void deleteShowTime(Long showTimeId);
}
