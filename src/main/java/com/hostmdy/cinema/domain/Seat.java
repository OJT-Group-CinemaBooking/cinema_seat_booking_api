package com.hostmdy.cinema.domain;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private SeatType type;
	private Integer price;
	private Integer rowNo;
	private Integer columnNo;
	
	@ManyToOne
	@JoinColumn(name = "seat_pattern_id")
	@JsonIgnore
	private SeatPattern seatPattern;
	
	@OneToMany(mappedBy = "seat")
	@JsonIgnore
	private List<BookSeat> bookSeat = new ArrayList<>();

}
