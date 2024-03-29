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
	public Optional<Coupon> getCouponById(Long couponId) {
		// TODO Auto-generated method stub
		return couponRepository.findById(couponId);
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
	public Coupon useCouponCode(Long couponId,String username) {
		// TODO Auto-generated method stub
		Optional<Coupon> couponOptional = couponRepository.findById(couponId);
		
		Coupon coupon = couponOptional.get();
		
		User user = findUserByUsername(username);
		
		coupon.setUserCount(coupon.getUserCount() - 1);
		couponRepository.save(coupon);
		saveUserCoupon(coupon, user);
		return coupon;
	}
	
	private User findUserByUsername(String username) {
		Optional<User> userOptional = userRepository.findByUsername(username);
		if(userOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("user","id","user with username="+username+" is not found.");
		}
		return userOptional.get();
	}
	
	private void saveUserCoupon(Coupon coupon,User user) {
		
		UserCoupon userCoupon = new UserCoupon();
		userCoupon.setCoupon(coupon);
		userCoupon.setUser(user);
		
		userCouponRepository.save(userCoupon);
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
