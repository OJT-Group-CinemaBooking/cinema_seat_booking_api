package com.hostmdy.cinema.domain;


import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hostmdy.cinema.domain.security.OneTimePassword;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private String password;
	private String role;
	private Boolean enable;

	private byte[] image;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "payment_id")
	private UserPayment userPayment;
	
	@OneToMany(mappedBy = "user")
	private List<UserCoupon> userCupons = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	private List<Ticket> tickets = new ArrayList<>();
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<OneTimePassword> otps = new HashSet<>();

	@PrePersist
	private void onPersist() {
		this.createdAt = LocalDateTime.now();
	}

	@PreUpdate
	private void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
}
