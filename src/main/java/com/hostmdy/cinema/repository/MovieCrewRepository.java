package com.hostmdy.cinema.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.MovieCrew;
import com.hostmdy.cinema.domain.Crew;
import com.hostmdy.cinema.domain.Movie;
import java.util.List;


public interface MovieCrewRepository extends CrudRepository<MovieCrew, Long>{
	
	List<MovieCrew> findByMovie(Movie movie);
	
	List<MovieCrew> findByCrew(Crew crew);

}
