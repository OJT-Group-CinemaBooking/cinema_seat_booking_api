package com.hostmdy.cinema.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.Movie;
import com.hostmdy.cinema.domain.ShowTime;



public interface MovieRepository extends CrudRepository<Movie, Long>{

	Movie findByTitle(String title);
	
	List<Movie> findByOrderByCreatedAtDesc();
	
	Optional<Movie> findByShowTime(ShowTime showTime);
	
}
