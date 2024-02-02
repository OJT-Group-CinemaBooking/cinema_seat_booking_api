package com.hostmdy.cinema.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.cinema.domain.ShowTime;
import com.hostmdy.cinema.domain.Ticket;

public interface TicketService {
	
	List<Ticket> getAllTickets();
	
	Ticket saveTicket(Ticket ticket);
	
	List<Ticket> getAllTicketsByShowTime(ShowTime showTime);
	
	Ticket createTicket(Ticket ticket,Long showtimeId,String username);
	
	Optional<Ticket> getTicketById(Long ticketId);
	
	void deleteTicketById(Long ticketId);

}
