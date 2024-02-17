package com.hostmdy.cinema.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.cinema.domain.Coupon;

public interface CouponService {
	Coupon CreateCoupon(Coupon coupon);
	
	Optional<Coupon> getCouponById(Long couponId);
	
	Coupon getCouponByCouponCode(String couponCode);
	
	Coupon useCouponCode(Long couponId,String username);
	
	List<Coupon> getAllCoupon();
	
	Boolean deleteCoupon(Long couponId);
}
