package com.hostmdy.cinema.domain;

import java.util.List;


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
public class SeatPattern {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private SeatType seatType;
	private Integer price;
	private Integer rowCount;
	private Integer columnCount;
	
	
	@ManyToOne
	@JoinColumn(name = "theater_id")
	private Theater theater;
	
	@OneToMany(mappedBy = "seatPattern")
	private List<Seat> seats;
}
