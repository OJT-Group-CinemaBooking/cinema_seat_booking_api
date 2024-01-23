package com.hostmdy.cinema.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
public class SeatPattern {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	private SeatType seatType;
	private Integer seatPrice;
	private Integer rowCount;
	private Integer columnCount;
	
	
	@ManyToOne
	@JoinColumn(name = "theater_id")
	@JsonIgnore
	private Theater theater;
	
	@OneToMany(mappedBy = "seatPattern",cascade = CascadeType.MERGE)
	private List<Seat> seats = new ArrayList<>();
}
