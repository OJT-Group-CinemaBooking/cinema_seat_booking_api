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
public class SeatPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Integer seatTypeOrder;
	private Integer rowCount;
	private Integer columnCount;
	
	@Enumerated(EnumType.STRING)
	private SeatType type;
	
	@ManyToOne
	@JoinColumn(name = "seat_pattern_id")
	@JsonIgnore
	private SeatPattern seatPattern;
	

}
