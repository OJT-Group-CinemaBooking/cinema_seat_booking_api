package com.hostmdy.cinema.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class OTPRequest {
	private String code;
}