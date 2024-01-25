package com.hostmdy.cinema.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.cinema.domain.ShowTime;
import com.hostmdy.cinema.domain.Ticket;

public interface TicketService {
	
	List<Ticket> getAllTickets();
	
	List<Ticket> getAllTicketsByShowTime(ShowTime showTime);
	
	Ticket saveTicket(Ticket ticket);
	
	Optional<Ticket> getTicketById(Long ticketId);
	
	void deleteTicketById(Long ticketId);

}
