package com.hostmdy.cinema.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String rating;
	private LocalDate releaseDate;
	private String country;
	private Integer duration;
	private String director;
	private Boolean showing;
	
	@Lob
	private byte[] image;
	
	@Lob
	private String synopsis;

}
