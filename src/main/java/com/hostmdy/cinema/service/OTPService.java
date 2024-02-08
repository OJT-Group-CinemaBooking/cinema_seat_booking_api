package com.hostmdy.cinema.service;

import com.hostmdy.cinema.domain.security.OneTimePassword;

public interface OTPService {
	
	OneTimePassword saveOTP(OneTimePassword oneTimePassword);

	OneTimePassword createOTP(String username);
	
	boolean validateOTP(String code,String username);


}
