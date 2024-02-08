package com.hostmdy.cinema.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserPayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String street;
	private String country;
	private String city;
	private String zip;
	
	private String holderName;
	private String cardNumber;
	
	@Enumerated(EnumType.STRING)
	private CardType cardType;
	private Integer expiryMonth;
	private Integer expiryYear;
	private Integer cvv;
	
	@OneToOne(mappedBy = "userPayment")
	@JsonIgnore
	private User user;

}
