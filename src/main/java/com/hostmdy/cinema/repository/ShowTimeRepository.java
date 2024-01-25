package com.hostmdy.cinema.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.Movie;
import com.hostmdy.cinema.domain.ShowTime;
import com.hostmdy.cinema.domain.Theater;

import java.util.List;


public interface ShowTimeRepository extends CrudRepository<ShowTime,Long>{
	List<ShowTime> findByMovie(Movie movie);
	
	List<ShowTime> findByTheater(Theater theater);
}
