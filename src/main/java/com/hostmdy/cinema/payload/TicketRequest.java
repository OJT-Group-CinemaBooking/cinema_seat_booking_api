package com.hostmdy.cinema.payload;

import com.hostmdy.cinema.domain.ShowTime;
import com.hostmdy.cinema.domain.Ticket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TicketRequest {
	
	private Ticket ticket;
	private ShowTime showTime;

}
