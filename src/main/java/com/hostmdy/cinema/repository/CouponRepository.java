package com.hostmdy.cinema.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.Coupon;
import java.util.Optional;


public interface CouponRepository extends CrudRepository<Coupon, Long>{
	Optional<Coupon> findByCouponCode(String cuponCode);
}
