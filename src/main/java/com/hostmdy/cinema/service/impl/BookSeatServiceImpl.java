package com.hostmdy.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.BookSeat;
import com.hostmdy.cinema.domain.ShowTime;
import com.hostmdy.cinema.exception.DatabaseResourceNotFoundException;
import com.hostmdy.cinema.repository.BookSeatRepository;
import com.hostmdy.cinema.repository.ShowTimeRepository;
import com.hostmdy.cinema.service.BookSeatService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookSeatServiceImpl implements BookSeatService{
	
	private final BookSeatRepository bookSeatRepository;
	private final ShowTimeRepository showTimeRepository;

	@Override
	public BookSeat getBookSeatById(Long bookseatId) {
		// TODO Auto-generated method stub
		Optional<BookSeat> bookSeatOptional = bookSeatRepository.findById(bookseatId);
		if(bookSeatOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("BookSeat", "id", "BookSeat with id :"+bookseatId+" is not found!");
		}
		return bookSeatOptional.get();
	}

	@Override
	public List<BookSeat> getByShowTimeId(Long showTimeId) {
		// TODO Auto-generated method stub
		Optional<ShowTime> showTimeOptional = showTimeRepository.findById(showTimeId);
		if(showTimeOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("ShowTime", "id", "ShowTime with id :"+showTimeId+" is not found!");
		}
		return bookSeatRepository.findByShowTime(showTimeOptional.get());
	}

	@Override
	public BookSeat takeBookSeat(Long bookseatId) {
		// TODO Auto-generated method stub
		BookSeat bookseat = getBookSeatById(bookseatId);
		bookseat.setTaken(true);
		return bookSeatRepository.save(bookseat);
	}

}
