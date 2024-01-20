package com.hostmdy.cinema.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.cinema.domain.ShowTime;
import com.hostmdy.cinema.service.ShowTimeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/showtime")
public class ShowTimeController {
	
	private final ShowTimeService showTimeService;
	
	@GetMapping("/all")
	public ResponseEntity<List<ShowTime>> getAllShowTime(){
		return ResponseEntity.ok(showTimeService.getAllShowTime());
	}
	
	@PostMapping("/create/{theaterId}")
	public ResponseEntity<ShowTime> createShowTime(@RequestBody ShowTime showTime,@PathVariable Long theaterId){
		return ResponseEntity.ok(showTimeService.createShowTime(showTime, theaterId));
	}
	
	@GetMapping("/{showTimeId}")
	public ResponseEntity<ShowTime> getShowTimeById(@PathVariable Long showTimeId){
		Optional<ShowTime> showTimeOptional = showTimeService.getShowTimeById(showTimeId);
		if(showTimeOptional.isEmpty()) {
			throw new NullPointerException();
		}
		
		return ResponseEntity.ok(showTimeOptional.get());
	}

}
