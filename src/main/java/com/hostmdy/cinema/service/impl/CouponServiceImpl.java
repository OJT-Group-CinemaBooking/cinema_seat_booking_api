package com.hostmdy.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostmdy.cinema.domain.Coupon;
import com.hostmdy.cinema.domain.User;
import com.hostmdy.cinema.domain.UserCoupon;
import com.hostmdy.cinema.exception.DatabaseResourceNotFoundException;
import com.hostmdy.cinema.exception.AlreadyExistsException;
import com.hostmdy.cinema.repository.CouponRepository;
import com.hostmdy.cinema.repository.UserCouponRepository;
import com.hostmdy.cinema.repository.UserRepository;
import com.hostmdy.cinema.service.CouponService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService{
	
	private final CouponRepository couponRepository;
	private final UserRepository userRepository;
	private final UserCouponRepository userCouponRepository;

	@Override
	public Coupon CreateCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		Optional<Coupon> couponOptional = couponRepository.findByCouponCode(coupon.getCouponCode());
		if(couponOptional.isPresent()) {
			throw new AlreadyExistsException("Coupon Code is already exists");
		}
		return couponRepository.save(coupon);
	}

	@Override
	public Coupon getCouponByCouponCode(String couponCode) {
		// TODO Auto-generated method stub
		Optional<Coupon> couponOptional = couponRepository.findByCouponCode(couponCode);
		if(couponOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("coupon","couponCode","coupon with couponCode= "+couponCode+" is not found.");
		}
		
		Coupon coupon = couponOptional.get();
		return coupon;
	}

	@Override
	public List<Coupon> getAllCoupon() {
		// TODO Auto-generated method stub
		return (List<Coupon>) couponRepository.findAll();
	}

	@Override
	@Transactional
	public Boolean useCouponCode(Long couponId,Long userId) {
		// TODO Auto-generated method stub
		Optional<Coupon> couponOptional = couponRepository.findById(couponId);
		if(couponOptional.isEmpty()) {
			return false;
		}
		Coupon coupon = couponOptional.get();
		
		User user = findUserById(userId);
		
		coupon.setUserCount(coupon.getUserCount() - 1);
		saveUserCoupon(coupon, user);
		return true;
	}
	
	private User findUserById(Long userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		if(userOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("user","id","user with id="+userId+" is not found.");
		}
		return userOptional.get();
	}
	
	private void saveUserCoupon(Coupon coupon,User user) {
		
		UserCoupon userCoupon = new UserCoupon();
		userCoupon.setCoupon(coupon);
		userCoupon.setUser(user);
		
		userCouponRepository.save(userCoupon);
	}
	
	private Boolean checkUserIsUsed(Long userId,Coupon coupon) {
		User user = findUserById(userId);
		List<UserCoupon> userCoupons = userCouponRepository.findByUser(user);
		
		for(UserCoupon userCoupon : userCoupons) {
			if(userCoupon.getCoupon() == coupon) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Boolean deleteCoupon(Long couponId) {
		// TODO Auto-generated method stub
		Optional<Coupon> couponOptional = couponRepository.findById(couponId);
		if(couponOptional.isEmpty()) {
			return false;
		}
		couponRepository.deleteById(couponId);
		return true;
	}
	
	

}
