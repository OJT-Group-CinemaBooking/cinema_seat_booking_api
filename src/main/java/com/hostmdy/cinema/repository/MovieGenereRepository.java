package com.hostmdy.cinema.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.MovieGenere;
import com.hostmdy.cinema.domain.Movie;
import java.util.List;


public interface MovieGenereRepository extends CrudRepository<MovieGenere, Long>{
	
	List<MovieGenere> findByMovie(Movie movie);

}
