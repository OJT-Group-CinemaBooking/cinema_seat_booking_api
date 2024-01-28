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

import com.hostmdy.cinema.domain.ShowTime;
import com.hostmdy.cinema.service.ShowTimeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/showtime")
public class ShowTimeController {
	
	private final ShowTimeService showTimeService;
	
	@GetMapping("/all")
	public ResponseEntity<List<ShowTime>> getAllShowTime(){
		return ResponseEntity.ok(showTimeService.getAllShowTime());
	}
	
	@PostMapping("/{theaterId}/{movieId}/create")
	public ResponseEntity<ShowTime> createShowTime(@RequestBody ShowTime showTime,@PathVariable Long theaterId,@PathVariable Long movieId){
		return ResponseEntity.ok(showTimeService.createShowTime(showTime, theaterId,movieId));
	}
	
	@GetMapping("/{showTimeId}")
	public ResponseEntity<ShowTime> getShowTimeById(@PathVariable Long showTimeId){
		Optional<ShowTime> showTimeOptional = showTimeService.getShowTimeById(showTimeId);
		if(showTimeOptional.isEmpty()) {
			throw new NullPointerException();
		}
		
		return ResponseEntity.ok(showTimeOptional.get());
	}
	
	@GetMapping("/movie/{movieId}")
	public ResponseEntity<List<ShowTime>> getShowTimeByMovieId(@PathVariable Long movieId){
		return ResponseEntity.ok(showTimeService.getShowTimeByMovieId(movieId));
	}
	
	@GetMapping("/theater/{theaterId}")
	public ResponseEntity<List<ShowTime>> getShowTimeByTheaterId(@PathVariable Long theaterId){
		return ResponseEntity.ok(showTimeService.getShowTimeByTheaterId(theaterId));
	}
	
	@PutMapping("/update")
	public ResponseEntity<ShowTime> updateShowTime(@RequestBody ShowTime showTime){
		return ResponseEntity.ok(showTimeService.updateShowTime(showTime));
	}

	@DeleteMapping("/{showTimeId}/delete")
	public ResponseEntity<Long> deleteShowTimeById(@PathVariable Long showTimeId){
		Boolean delete = showTimeService.deleteShowTime(showTimeId);
		if(!delete) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(showTimeId);
	}
}
