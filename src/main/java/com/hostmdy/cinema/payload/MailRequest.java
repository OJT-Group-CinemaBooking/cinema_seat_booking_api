package com.hostmdy.cinema.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class MailRequest {
	
	private String name;
	private String subject;
	private String message;
	private String from;

}
