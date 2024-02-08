package com.hostmdy.cinema.config;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.hostmdy.cinema.domain.User;
import com.hostmdy.cinema.service.impl.UserSecurityService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	private final String HEADER = "Authorization";
	private final String TOKEN_PREFIX = "Bearer ";
	
	private final UserSecurityService userSecurityService;
	private final JwtTokenProvider tokenProvider;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String token = getTokenFromRequest(request);
			if(StringUtils.hasText(token) && tokenProvider.validateToken(token)) {
				Long userId = tokenProvider.getUserIdFromToken(token);
				User userDetails = userSecurityService.loadUserById(userId);
				
				UsernamePasswordAuthenticationToken authToken = 
					UsernamePasswordAuthenticationToken.authenticated(userDetails, userDetails, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.error("token filter is failed");
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	private String getTokenFromRequest(HttpServletRequest request) {
		String rawToken = request.getHeader(HEADER);
		if(StringUtils.hasText(rawToken) && rawToken.startsWith(TOKEN_PREFIX)) {
			return rawToken.substring(7,rawToken.length());
		}else {
			throw new NullPointerException("token is null");
		}
	}

}
