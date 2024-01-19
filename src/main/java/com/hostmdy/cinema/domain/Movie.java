package com.hostmdy.cinema.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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
	private LocalDate releaseDate;
	private Integer duration;
	private Double rating;
	private String country;
	private String language;
	private boolean nowShowing;
	private boolean comingSoon;
	private boolean popularNow;
	private boolean showing;
	private String trailer;
	
	@Lob
	private String synopsis;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	@OneToMany(mappedBy = "movie")
	List<MovieGenere> movieGenere = new ArrayList<>();
	
	@OneToMany(mappedBy = "movie")
	List<MovieCrew> movieCrew = new ArrayList<>();
	
	@PrePersist
	private void onPersist() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	private void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

}
