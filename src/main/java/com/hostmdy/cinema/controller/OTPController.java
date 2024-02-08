package com.hostmdy.cinema.controller;


import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.cinema.domain.security.OneTimePassword;
import com.hostmdy.cinema.exception.InvalidOTPException;
import com.hostmdy.cinema.payload.OTPRequest;
import com.hostmdy.cinema.service.OTPService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/otp")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class OTPController {
	private final OTPService otpService;
	
	@PostMapping("/create/{username}")
	public ResponseEntity<?> createOTP(@PathVariable String username){
		OneTimePassword otp = otpService.createOTP(username);
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/validate/{username}")
	public ResponseEntity<?> validateOTP(@RequestBody OTPRequest otpRequest,@PathVariable String username){
		boolean otpValidated = otpService.validateOTP(otpRequest.getCode(),username);
		
		if(!otpValidated) {
			throw new InvalidOTPException("otp is invalid");
		}

		return ResponseEntity.ok().build();
	}
}

