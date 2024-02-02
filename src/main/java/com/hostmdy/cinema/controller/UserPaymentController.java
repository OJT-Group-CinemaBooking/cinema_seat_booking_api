package com.hostmdy.cinema.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.cinema.domain.UserPayment;
import com.hostmdy.cinema.service.UserPaymentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/userpayment")
public class UserPaymentController {
	
	private final UserPaymentService userPaymentService;
	
	@GetMapping("/get")
	public ResponseEntity<UserPayment> getUserPayment(String username){
		return ResponseEntity.ok(userPaymentService.getUserPayments(username));
	}
	
	@GetMapping("/{userPaymentId}")
	public ResponseEntity<UserPayment> getUserPaymentById(@PathVariable Long userPaymentId) {
		Optional<UserPayment> userPaymentOptional = userPaymentService.getUserPaymentById(userPaymentId);
		if (userPaymentOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userPaymentOptional.get());
	}
	
	@PostMapping("/create")/*, @RequestBody String username*/
	public ResponseEntity<UserPayment> createUserPayment(@RequestBody UserPayment payment){
//		return ResponseEntity.ok(userPaymentService.createUserPayment(userPayment, username));
		
		return ResponseEntity.ok(userPaymentService.createUserPayment(payment, "mm001"));
	}
	
	@PutMapping("/update")
	public ResponseEntity<UserPayment> updateUserPayment(@RequestBody UserPayment userPayment, @RequestBody String username) {
		return ResponseEntity.ok(userPaymentService.updateUserPayment(userPayment, username));
	}

	@DeleteMapping("/{userPaymentId}/delete")
	public ResponseEntity<Long> deleteUserPaymentById(@PathVariable Long userPaymentId, @RequestBody String username) {
		userPaymentService.deleteUserPaymentById(userPaymentId, username);

		return ResponseEntity.ok(userPaymentId);
	}

}
