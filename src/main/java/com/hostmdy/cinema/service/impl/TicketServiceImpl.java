package com.hostmdy.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.Movie;
import com.hostmdy.cinema.domain.ShowTime;
import com.hostmdy.cinema.domain.Ticket;
import com.hostmdy.cinema.domain.User;
import com.hostmdy.cinema.repository.MovieRepository;
import com.hostmdy.cinema.repository.ShowTimeRepository;
import com.hostmdy.cinema.repository.TicketRepository;
import com.hostmdy.cinema.repository.UserRepository;
import com.hostmdy.cinema.service.TicketService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
	
	private final TicketRepository ticketRepository;
	private final ShowTimeRepository showTimeRepository;
	private final UserRepository userRepository;
	private final MovieRepository movieRepository;
	

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return (List<Ticket>) ticketRepository.findAll();
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> getAllTicketsByShowTime(ShowTime showTime) {
		// TODO Auto-generated method stub
		return ticketRepository.findTicketByShowTime(showTime);
	}

//	
//	Long Ticket saveTicket(Ticket ticket, ShowTime showTime) {
//		// TODO Auto-generated method stub
//		showTime.getTickets().add(ticket);
//		showTimeRepository.save(showTime);
//		ticket.setShowTime(showTime);
//		return ticketRepository.save(ticket);
//	}

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

	@Override
	public Ticket createTicket(Ticket ticket, Long showtimeId, String username) {
		// TODO Auto-generated method stub
		
		Optional<ShowTime> showTimeOptional = showTimeRepository.findById(showtimeId);
		Optional<User> userOptional = userRepository.findByUsername(username);
		
		ShowTime showTime = showTimeOptional.get();
		Movie movie = movieRepository.findByShowTime(showTime).get();
		ticket.setMovieTitle(movie.getTitle());
		ticket.setShowTime(showTime);
		ticket.setUser(userOptional.get());
		Ticket createdTicket = saveTicket(ticket);
		
		return createdTicket;
	}

}
