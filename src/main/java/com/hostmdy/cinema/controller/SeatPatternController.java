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

import com.hostmdy.cinema.domain.SeatPattern;
import com.hostmdy.cinema.service.SeatPatternService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/seatPattern")
@CrossOrigin("http://localhost:3000")
public class SeatPatternController {
	
	private final SeatPatternService seatPatternService;
	
	@GetMapping("/all")
	public ResponseEntity<List<SeatPattern>> getAllSeatPattern() {
		
		return ResponseEntity.ok(seatPatternService.getAllSeatPattern());
	}
	
	@GetMapping("/all/{theaterId}")
	public ResponseEntity<List<SeatPattern>> getAllSeatPatternByTheater(@PathVariable Long theaterId) {
		
		return ResponseEntity.ok(seatPatternService.getAllSeatPatternByTheaterId(theaterId));
	}
	
	@GetMapping("/{seatPatternId}")
	public ResponseEntity<SeatPattern> getSeatPatternById(@PathVariable Long seatPatternId) {
		Optional<SeatPattern> seatPatternOptional = seatPatternService.getSeatPatternById(seatPatternId);
		if(seatPatternOptional.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(seatPatternOptional.get());
	}
	
	@PostMapping("/create/{theaterId}")
	public ResponseEntity<SeatPattern> createSeatPattern(@PathVariable Long theaterId,@RequestBody SeatPattern seatPattern) {
		
		return ResponseEntity.ok(seatPatternService.createSeatPattern(theaterId, seatPattern));
	}
	
	@PutMapping("/update/{theaterId}")
	public ResponseEntity<SeatPattern> updateSeatPattern(@PathVariable Long theaterId,@RequestBody SeatPattern seatPattern) {
		if((seatPattern.getId() == null) || seatPatternService.getSeatPatternById(seatPattern.getId()).isEmpty()) {
			ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(seatPatternService.updateSeatPattern(theaterId, seatPattern));
	}
	
	@DeleteMapping("/delete/{seatPatternId}")
	public ResponseEntity<Long> deleteSeatPattern(@PathVariable Long seatPatternId) {
		Boolean success = seatPatternService.deleteSeatPatternById(seatPatternId);
		if(!success) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(seatPatternId);
	}

}
