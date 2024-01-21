package com.hostmdy.cinema.domain;


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
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private SeatType type;
	private Integer price;
	private Integer rowCount;
	private Integer columnCount;
	
	@ManyToOne
	@JoinColumn(name = "seat_pattern_id")
	private SeatPattern seatPattern;
	


}
