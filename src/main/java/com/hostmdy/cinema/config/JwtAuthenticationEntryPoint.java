package com.hostmdy.cinema.config;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.google.gson.Gson;
import com.hostmdy.cinema.payload.InvalidLoginResponse;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		InvalidLoginResponse invalidResponse = new InvalidLoginResponse();
		String responseJson = new Gson().toJson(invalidResponse);
		response.setContentType("application/json");
		response.setStatus(403);
		response.getWriter().print(responseJson);
	}
	
	
}
