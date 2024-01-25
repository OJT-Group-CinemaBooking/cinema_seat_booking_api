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
import com.hostmdy.cinema.domain.Ticket;
import com.hostmdy.cinema.exception.DatabaseResourceNotFoundException;
import com.hostmdy.cinema.service.TicketService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ticket")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class TicketController {
	
	private final TicketService ticketService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Ticket>> getAllTicketsByShowTime(@RequestBody ShowTime showTime){
		return ResponseEntity.ok(ticketService.getAllTicketsByShowTime(showTime));
	}
	
	@GetMapping("/{ticketId}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable Long ticketId){
		Optional<Ticket> ticketOptional = ticketService.getTicketById(ticketId);
		
		if(ticketOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("Ticket", "Id", "Ticket with Id: "+ticketId+" is not found");
		}
		return ResponseEntity.ok(ticketOptional.get());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket){
		return ResponseEntity.ok(ticketService.saveTicket(ticket));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket){
		if(ticket.getId() == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(ticketService.saveTicket(ticket));
	}
	
	@DeleteMapping("/{ticketId}/delete")
	public ResponseEntity<Long> deleteTicket(@PathVariable Long ticketId){
		if(ticketService.getTicketById(ticketId).isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		ticketService.deleteTicketById(ticketId);
		return ResponseEntity.ok(ticketId);
	}

}
