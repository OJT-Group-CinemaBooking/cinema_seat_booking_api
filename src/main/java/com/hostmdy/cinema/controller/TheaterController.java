package com.hostmdy.cinema.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{theaterId}")
	public ResponseEntity<Theater> getTheaterById(@PathVariable Long theaterId){
		return ResponseEntity.ok(theaterService.getTheaterById(theaterId).get());
	}
}
