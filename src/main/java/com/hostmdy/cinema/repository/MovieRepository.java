package com.hostmdy.cinema.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.Movie;


public interface MovieRepository extends CrudRepository<Movie, Long>{

	Movie findByTitle(String title);
	
	List<Movie> findByOrderByCreatedAtDesc();
	
}
