package com.hostmdy.cinema.service;

import java.util.List;

import com.hostmdy.cinema.domain.Coupon;

public interface CouponService {
	Coupon CreateCoupon(Coupon coupon);
	
	Coupon getCouponByCouponCode(String couponCode);
	
	Boolean useCouponCode(Long couponId,Long userId);
	
	List<Coupon> getAllCoupon();
	
	Boolean deleteCoupon(Long couponId);
}
