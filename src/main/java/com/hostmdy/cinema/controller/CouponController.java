package com.hostmdy.cinema.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.cinema.domain.Coupon;
import com.hostmdy.cinema.service.CouponService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/coupon")
@CrossOrigin("http://localhost:3000")
public class CouponController {
	
	private final CouponService couponService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Coupon>> getAllCoupon(){
		return ResponseEntity.ok(couponService.getAllCoupon());
	}
	
	@GetMapping("/find/{couponCode}")
	public ResponseEntity<Coupon> getCouponByCouponCode(@PathVariable String couponCode){
		Coupon coupon = couponService.getCouponByCouponCode(couponCode);
//		if(coupon.getExpiryDate().isBefore(LocalDate.now()) || coupon.getUserCount() == 0) {
//			return ResponseEntity.badRequest().build();
//		}
		return ResponseEntity.ok(coupon);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Coupon> createCoupon(@RequestBody Coupon coupon){
		return ResponseEntity.ok(couponService.CreateCoupon(coupon));
	}
	
	@GetMapping("/{couponId}/{userId}/use")
	public ResponseEntity<?> useCouponCode(@PathVariable Long couponId,@PathVariable Long userId){
		Boolean isUseSuccess = couponService.useCouponCode(couponId, userId);
		if(!isUseSuccess) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{couponId}/delete")
	public ResponseEntity<Long> deleteCoupon(@PathVariable Long couponId){
		Boolean isDelete = couponService.deleteCoupon(couponId);
		if(!isDelete) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(couponId);
	}
}
