package com.hostmdy.cinema.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.User;
import com.hostmdy.cinema.domain.UserCoupon;

import java.util.List;


public interface UserCouponRepository extends CrudRepository<UserCoupon, Long>{
	List<UserCoupon> findByUser(User user);
}
