package com.hostmdy.cinema.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.Ticket;
import java.util.List;
import com.hostmdy.cinema.domain.ShowTime;


public interface TicketRepository extends CrudRepository<Ticket, Long> {
	
	List<Ticket> findTicketByShowTime(ShowTime showTime);

}
