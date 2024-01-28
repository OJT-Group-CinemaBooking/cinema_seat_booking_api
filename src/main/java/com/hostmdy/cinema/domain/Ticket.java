package com.hostmdy.cinema.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String theaterName;
	private String movieTitle;
	private Integer totalPrice;
	private Integer actualPrice;
	
	@ManyToOne
	@JoinColumn(name = "show_time_id")
	private ShowTime showTime;
	
	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
	private List<BoughtSeat> boughtSeats = new ArrayList<>();

}
