package com.hostmdy.cinema.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.BookSeat;
import com.hostmdy.cinema.domain.ShowTime;


public interface BookSeatRepository extends CrudRepository<BookSeat,Long>{
	
	List<BookSeat> findByShowTime(ShowTime showTime);

}
