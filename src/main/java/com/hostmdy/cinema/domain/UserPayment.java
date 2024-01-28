package com.hostmdy.cinema.domain;

import jakarta.persistence.Entity;
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
	
	private String holderName;
	private Integer cardNumber;
	private CardType cardType;
	private Integer expiryMonth;
	private Integer expiryYear;
	
	@OneToOne(mappedBy = "userPayment")
	private User user;

}
