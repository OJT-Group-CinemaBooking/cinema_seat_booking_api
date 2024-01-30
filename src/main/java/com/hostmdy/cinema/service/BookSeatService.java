package com.hostmdy.cinema.service;

import java.util.List;

import com.hostmdy.cinema.domain.BookSeat;

public interface BookSeatService {
	
	List<BookSeat> getByShowTimeId(Long showTimeId);

}
