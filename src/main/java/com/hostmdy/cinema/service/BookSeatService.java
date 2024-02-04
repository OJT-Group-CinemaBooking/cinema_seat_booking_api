package com.hostmdy.cinema.service;

import java.util.List;

import com.hostmdy.cinema.domain.BookSeat;

public interface BookSeatService {
	
	BookSeat getBookSeatById(Long bookseatId);
	
	List<BookSeat> getByShowTimeId(Long showTimeId);
	
	BookSeat takeBookSeat(Long bookseatId);

}
