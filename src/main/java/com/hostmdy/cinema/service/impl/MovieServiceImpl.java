package com.hostmdy.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostmdy.cinema.domain.Crew;
import com.hostmdy.cinema.domain.Genere;
import com.hostmdy.cinema.domain.Movie;
import com.hostmdy.cinema.domain.MovieCrew;
import com.hostmdy.cinema.domain.MovieGenere;
import com.hostmdy.cinema.domain.ShowTime;
import com.hostmdy.cinema.exception.DatabaseResourceNotFoundException;
import com.hostmdy.cinema.repository.MovieCrewRepository;
import com.hostmdy.cinema.repository.MovieGenereRepository;
import com.hostmdy.cinema.repository.MovieRepository;
import com.hostmdy.cinema.repository.ShowTimeRepository;
import com.hostmdy.cinema.service.MovieService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{
	
	private final MovieRepository movieRepository;
	private final MovieGenereRepository movieGenereRepository;
	private final MovieCrewRepository movieCrewRepository;
	private final ShowTimeRepository showTimeRepository;

	@Override
	public Movie saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movieRepository.save(movie);
	}

	@Override
	public Optional<Movie> getMovieById(Long movieId) {
		// TODO Auto-generated method stub
		return movieRepository.findById(movieId);
	}

	@Override
	public List<Movie> getAllMovie() {
		// TODO Auto-generated method stub
		List<Movie> movieList = (List<Movie>) movieRepository.findByOrderByCreatedAtDesc();
		return movieList.stream().sorted((m1,m2) -> m1.getReleaseDate().isAfter(m2.getReleaseDate())? 1 : -1).toList();
	}

	@Override
	public Movie createMovie(Movie movie) {
		// TODO Auto-generated method stub
		movie = movieRepository.save(movie);
		return movie;
	}

	@Override
	public boolean deleteMovieById(Long movieId) {
		// TODO Auto-generated method stub
		if(getMovieById(movieId).isEmpty()) {
			return false;
		}
		
		List<MovieGenere> movieGenereList = movieGenereRepository.findByMovie(getMovieById(movieId).get());
		movieGenereRepository.deleteAll(movieGenereList);
		List<MovieCrew> movieCrewList = movieCrewRepository.findByMovie(getMovieById(movieId).get());
		movieCrewRepository.deleteAll(movieCrewList);
		
		movieRepository.deleteById(movieId);
		return true;
	}
	
	private void addNewGenere(Movie movie,Genere genere) {
		MovieGenere movieGenere = new MovieGenere();
		movieGenere.setGenere(genere);
		movieGenere.setMovie(movie);
		movieGenereRepository.save(movieGenere);
	}

	@Override
	@Transactional
	public Movie addGenere(Long movieId, List<Genere> genereList) {
		// TODO Auto-generated method stub
		Movie movie = getMovieById(movieId).get();
		List<MovieGenere> existedMovieGenereList = movieGenereRepository.findByMovie(movie);
		if(existedMovieGenereList.isEmpty()) {
			if(!genereList.isEmpty()) {
				for (Genere genere : genereList) {
					addNewGenere(movie, genere);
				}
			}
		}else {
			List<MovieGenere> notMatchMovieGeneres = existedMovieGenereList.stream()
					.filter(emg -> genereList.stream().noneMatch( g -> g.equals(emg.getGenere()))).toList();
			for (Genere genere : genereList) {
				if(!existedMovieGenereList.stream().anyMatch( emg -> emg.getGenere().equals(genere))) {
					addNewGenere(movie, genere);
				}
			}
			movieGenereRepository.deleteAll(notMatchMovieGeneres);
		}
		return movie;
	}
	
	private void addNewCrew(Movie movie,Crew crew) {
		MovieCrew movieCrew = new MovieCrew();
		movieCrew.setCrew(crew);
		movieCrew.setMovie(movie);
		movieCrewRepository.save(movieCrew);
	}

	@Override
	public Movie addCrew(Long movieId, List<Crew> crewList) {
		// TODO Auto-generated method stub
		Movie movie = getMovieById(movieId).get();
		List<MovieCrew> existedMovieCrewList = movieCrewRepository.findByMovie(movie);
		if(existedMovieCrewList.isEmpty()) {
			if(!crewList.isEmpty()) {
				for (Crew crew : crewList) {
					addNewCrew(movie, crew);
				}
			}
		}else {
			List<MovieCrew> notMatchMovieCrews = existedMovieCrewList.stream()
					.filter( mc -> crewList.stream().noneMatch(c -> c.equals(mc.getCrew()) )).toList();
			for (final Crew crew : crewList) {
				if(!existedMovieCrewList.stream().anyMatch(emc -> emc.getCrew().equals(crew))) {
					addNewCrew(movie, crew);
				}
			}
			movieCrewRepository.deleteAll(notMatchMovieCrews);
		}
		return movie;
	}

	@Override
	public Movie getMovieByShowTimeId(Long showTimeId) {
		// TODO Auto-generated method stub
		Optional<ShowTime> showTimeOptional = showTimeRepository.findById(showTimeId);
		if(showTimeOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("ShowTime", "id", "ShowTime width id : "+showTimeId+" is not found!");
		}
		Optional<Movie> movieOptional = movieRepository.findByShowTime(showTimeOptional.get());
		if(movieOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("Movie", "showTime", "Movie width showTimeId : "+showTimeId+" is not found!");
		}
		
		return movieOptional.get();
	}
	
	

}
