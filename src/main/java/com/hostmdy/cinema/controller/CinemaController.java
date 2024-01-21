package com.hostmdy.cinema.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.cinema.domain.Cinema;
import com.hostmdy.cinema.service.CinemaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cinema")
@CrossOrigin("http://localhost:3000")
public class CinemaController {
	private final CinemaService cinemaService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Cinema>> getAllCinema(){
		return ResponseEntity.ok(cinemaService.getAllCinema());
	}
	
	@GetMapping("/{cinemaId}")
	public ResponseEntity<Cinema> getCinemaById(@PathVariable Long cinemaId){
		return ResponseEntity.ok(cinemaService.getCinemaById(cinemaId).get());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Cinema> createCinema(@RequestBody Cinema cinema){
		return ResponseEntity.ok(cinemaService.createCinema(cinema));
	}
	
	@PostMapping("/update")
	public ResponseEntity<Cinema> updateCinema(@RequestBody Cinema cinema){
		return ResponseEntity.ok(cinemaService.updateCinema(cinema));
	}
	
	@PostMapping("/delete/{cinemaId}")
	public ResponseEntity<Long> deleteCinema(@PathVariable Long cinemaId){
		if(!cinemaService.deleteCinemaById(cinemaId)) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(cinemaId);
	}
}
