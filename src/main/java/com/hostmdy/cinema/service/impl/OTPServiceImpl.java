package com.hostmdy.cinema.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostmdy.cinema.domain.User;
import com.hostmdy.cinema.domain.security.OneTimePassword;
import com.hostmdy.cinema.exception.DatabaseResourceNotFoundException;
import com.hostmdy.cinema.exception.IllegalResourceAccessException;
import com.hostmdy.cinema.repository.OneTimePasswordRepository;
import com.hostmdy.cinema.repository.UserRepository;
import com.hostmdy.cinema.service.OTPService;
import com.hostmdy.cinema.utility.MailConstructor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OTPServiceImpl implements OTPService{

	private final OneTimePasswordRepository otpRepository;
	private final UserRepository userRepository;
	private final MailConstructor mailConstructor;
	private final JavaMailSender mailSender;
	private final Environment env;
	
	private boolean hasCurrentUser(String code,User user) {
		return otpRepository.findByUser(user).stream()
				.anyMatch(otp -> code.equals(otp.getCode()));
	}
	
	private User getUser(String username) {
		Optional<User> userOptional = userRepository.findByUsername(username);
		
		if(userOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("User","username","user with username="+username+" is not found");
		}

		return userOptional.get();
	}
	
	@Override
	public OneTimePassword saveOTP(OneTimePassword oneTimePassword) {
		// TODO Auto-generated method stub
		return otpRepository.save(oneTimePassword);
	}
	@Override
	@Transactional
	public boolean validateOTP(String code, String username) {
		// TODO Auto-generated method stub
		User user = getUser(username);
		Optional<OneTimePassword> otpOptional = otpRepository.findByCode(code);
		
		if(otpOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("OneTimePassword","code,user","opt code is not found in database");
		}
		OneTimePassword otp = otpOptional.get();
		
		if(!hasCurrentUser(code, user)) {
			throw new IllegalResourceAccessException("you cant access this resource");
		}
		
		if(otp.getExpiryDate().isBefore(LocalDateTime.now())) {
			log.info("otp date is expired");
			otp.setExpiry(true);
			saveOTP(otp);
			return false;
		}
		
		if(otp.getExpiry()) {
			log.info("otp is expired");
			return false;
		}
		
		user.setEnable(true);
		userRepository.save(user);
		
		otp.setExpiry(true);
		saveOTP(otp);
		return true;
	}
	
	@Override
	@Transactional
	public OneTimePassword createOTP(String username) {
		// TODO Auto-generated method stub
		User user = getUser(username);
		List<OneTimePassword> otps = otpRepository.findByUser(user);
		for(final OneTimePassword otp : otps) {
			otp.setExpiry(true);
		}
		otpRepository.saveAll(otps);
		
		OneTimePassword newOtp = new OneTimePassword();
		newOtp.setUser(user);
		user.getOtps().add(newOtp);
		newOtp = saveOTP(newOtp);
		
		mailSender.send(mailConstructor.constructSimpleMail(
			env.getProperty("otp.mail.subject"), 
			env.getProperty("otp.mail.message")+"\n"+newOtp.getCode(), 
			user.getEmail(),
			env.getProperty("support.mail") 
		));
		
		return newOtp;
	}

}
