package com.hostmdy.cinema.domain;

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
public class Theater {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String Screen;
	
	@ManyToOne
	@JoinColumn(name = "cinema_id")
	@JsonIgnore
	private Cinema cinema;

	@OneToMany(mappedBy = "theater")
	private List<SeatPattern> seatPatterns;
	
	@OneToMany(mappedBy = "theater")
	private List<ShowTime> showTime;

}
