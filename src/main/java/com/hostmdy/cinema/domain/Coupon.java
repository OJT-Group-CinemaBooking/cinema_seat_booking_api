package com.hostmdy.cinema.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
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
public class Coupon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String couponCode;
	private Integer userCount;
	private LocalDate expiryDate;
	private Integer discount;
	
	@OneToMany(mappedBy = "coupon",cascade = CascadeType.ALL)
	private List<UserCoupon> userCoupons = new ArrayList<>();

}
