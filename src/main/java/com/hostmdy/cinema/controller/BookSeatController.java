package com.hostmdy.cinema.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.cinema.domain.BookSeat;
import com.hostmdy.cinema.service.BookSeatService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/bookSeat")
@CrossOrigin("http://localhost:3000")
public class BookSeatController {
	
	private final BookSeatService bookSeatService;
	
	@GetMapping("/all/{showTimeId}/showTime")
	public ResponseEntity<List<BookSeat>> getBookSeatListByShowTime(@PathVariable Long showTimeId) {
		return ResponseEntity.ok(bookSeatService.getByShowTimeId(showTimeId));
	}

}
