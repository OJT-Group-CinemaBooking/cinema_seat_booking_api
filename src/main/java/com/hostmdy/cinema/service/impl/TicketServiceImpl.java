package com.hostmdy.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.ShowTime;
import com.hostmdy.cinema.domain.Ticket;
import com.hostmdy.cinema.repository.ShowTimeRepository;
import com.hostmdy.cinema.repository.TicketRepository;
import com.hostmdy.cinema.service.TicketService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
	
	private final TicketRepository ticketRepository;
	private final ShowTimeRepository showTimeRepository;

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return (List<Ticket>) ticketRepository.findAll();
	}

	@Override
	public List<Ticket> getAllTicketsByShowTime(ShowTime showTime) {
		// TODO Auto-generated method stub
		return ticketRepository.findTicketByShowTime(showTime);
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		showTimeRepository.save(ticket.getShowTime());
		return ticketRepository.save(ticket);
	}

	@Override
	public Optional<Ticket> getTicketById(Long ticketId) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(ticketId);
	}

	@Override
	public void deleteTicketById(Long ticketId) {
		// TODO Auto-generated method stub
		ticketRepository.deleteById(ticketId);
	}

}
