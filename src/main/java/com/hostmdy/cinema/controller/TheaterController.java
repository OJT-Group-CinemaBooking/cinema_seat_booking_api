package com.hostmdy.cinema.controller;

import java.util.List;

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

import com.hostmdy.cinema.domain.Theater;
import com.hostmdy.cinema.service.TheaterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/theater")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class TheaterController {
	private final TheaterService theaterService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Theater>> getAllTheater(){
		return ResponseEntity.ok(theaterService.getAllTheater());
	}
	
	@GetMapping("/{theaterId}")
	public ResponseEntity<Theater> getTheaterById(@PathVariable Long theaterId){
		return ResponseEntity.ok(theaterService.getTheaterById(theaterId));
	}
	
	@GetMapping("/{cinemaId}/find")
	public ResponseEntity<List<Theater>> getTheaterByCinemaId(@PathVariable Long cinemaId){
		return ResponseEntity.ok(theaterService.getTheaterByCinemaId(cinemaId));
	}
	
	@PostMapping("/{cinemaId}/create")
	public ResponseEntity<Theater> createTheater(@RequestBody Theater theater, @PathVariable Long cinemaId){
		return ResponseEntity.ok(theaterService.createTheater(theater, cinemaId));
	}
	
	@PutMapping("/{cinemaId}/update")
	public ResponseEntity<Theater> updateTheater(@RequestBody Theater theater,@PathVariable Long cinemaId){
		if(theater.getId() == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(theaterService.updateTheater(theater, cinemaId));
	}
	
	@DeleteMapping("/{theaterId}/delete")
	public ResponseEntity<Long> deleteTheater(@PathVariable Long theaterId){
		theaterService.deleteTheater(theaterId);
		return ResponseEntity.ok(theaterId);
	}
}
