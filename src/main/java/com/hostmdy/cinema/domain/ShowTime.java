package com.hostmdy.cinema.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ShowTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDate showDate;
	private LocalTime showTime;
	
	@ManyToOne
	@JoinColumn(name = "theater_id")
	private Theater theater;
	
	@OneToMany(mappedBy = "showTime")
	private List<BookSeat> bookSeats = new ArrayList<>();
	
	@OneToMany(mappedBy = "showTime")
	@JsonIgnore
	private List<Ticket> tickets = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	@JsonIgnore
	private Movie movie;

}
