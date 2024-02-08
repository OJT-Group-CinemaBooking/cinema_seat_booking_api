package com.hostmdy.cinema.domain.security;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hostmdy.cinema.domain.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class OneTimePassword {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String code;
	private LocalDateTime issuedAt;
	private Boolean expiry = false;
	private LocalDateTime expiryDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;
	
	private String generateOTP() {
		Random random = new Random();
		StringBuilder strBuilder = new StringBuilder();
		for(int i = 0; i < 6; i++) {
			strBuilder.append(random.nextInt(10));
		}
		return strBuilder.toString();
	}
	
	@PrePersist
	private void onCreate() {
		this.code = generateOTP();
		issuedAt = LocalDateTime.now();
		this.expiryDate = issuedAt.plus(15,ChronoUnit.MINUTES);
	}
}
