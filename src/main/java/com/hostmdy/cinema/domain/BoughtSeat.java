package com.hostmdy.cinema.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BoughtSeat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long bookedSeatId;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private SeatType seatType;
	private Integer price;
	
	@ManyToOne
	@JoinColumn(name = "ticket_id")
	@JsonIgnore
	private Ticket ticket;

}
