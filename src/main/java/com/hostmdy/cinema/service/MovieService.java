package com.hostmdy.cinema.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.cinema.domain.Crew;
import com.hostmdy.cinema.domain.Genere;
import com.hostmdy.cinema.domain.Movie;

public interface MovieService {
	
	Movie saveMovie(Movie movie);
	
	Optional<Movie> getMovieById(Long movieId);
	
	List<Movie> getAllMovie();
	
	Movie createMovie(Movie movie);
	
	boolean deleteMovieById(Long movieId);
	
	Movie addGenere(Long movieId,List<Genere> genereList);
	
	Movie addCrew(Long movieId,List<Crew> crewList);

}
