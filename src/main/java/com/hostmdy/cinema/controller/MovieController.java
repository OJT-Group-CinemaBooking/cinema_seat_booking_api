package com.hostmdy.cinema.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.cinema.domain.Crew;
import com.hostmdy.cinema.domain.Genere;
import com.hostmdy.cinema.domain.Movie;
import com.hostmdy.cinema.service.MovieService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movie")
@CrossOrigin("http://localhost:3000")
public class MovieController {
	
	private final MovieService movieService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Movie>> getAllMovies() {
		return ResponseEntity.ok(movieService.getAllMovie());
	}
	
	@GetMapping("/{movieId}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Long movieId) {
		Optional<Movie> movieOptional = movieService.getMovieById(movieId);
		if(movieOptional.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(movieOptional.get());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Movie> createNewMovie(@RequestBody Movie movie) {
		return ResponseEntity.ok(movieService.createMovie(movie));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
		return ResponseEntity.ok(movieService.saveMovie(movie));
	}
	
	@DeleteMapping("/{movieId}/delete")
	public ResponseEntity<Long> deleteMovie(@PathVariable Long movieId) {
		if(!movieService.deleteMovieById(movieId)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(movieId);
	}
	
	@PostMapping("/{movieId}/addgenere")
	public ResponseEntity<Movie> addGenere(@PathVariable Long movieId,@RequestBody List<Genere> genereList) {
		return ResponseEntity.ok(movieService.addGenere(movieId, genereList));
	}
	
	@PostMapping("/{movieId}/addcrew")
	public ResponseEntity<Movie> addCrew(@PathVariable Long movieId,@RequestBody List<Crew> crewList) {
		return ResponseEntity.ok(movieService.addCrew(movieId, crewList));
	}

}
