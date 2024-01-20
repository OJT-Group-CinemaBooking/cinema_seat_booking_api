package com.hostmdy.cinema.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	private Integer seatTypeNumber;
	private String image;
	
	@OneToMany(mappedBy = "seatPattern")
	@JsonIgnore
	private List<Theater> theaters = new ArrayList<>();
	
	@OneToMany(mappedBy = "seatPattern")
	private List<SeatPosition> seatPosition = new ArrayList<>();

}
