package com.hostmdy.cinema.controller;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.cinema.payload.MailRequest;
import com.hostmdy.cinema.utility.MailConstructor;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail")
@CrossOrigin("http://localhost:3000")
public class ContactMailController {
	
	private final MailConstructor mailConstructor;
	private final JavaMailSender mailSender;
	private final Environment env;
	
	@PostMapping("/send")
	public ResponseEntity<?> sendMail(@RequestBody MailRequest mailRequest) {
		mailSender.send(mailConstructor.constructSimpleMail(
				mailRequest.getSubject(), 
				mailRequest.getMessage(), 
				env.getProperty("support.mail"), 
				mailRequest.getFrom()
				));
		return ResponseEntity.ok().build();
	}

}
