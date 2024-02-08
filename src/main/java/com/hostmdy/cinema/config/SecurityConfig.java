package com.hostmdy.cinema.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.hostmdy.cinema.service.impl.UserSecurityService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final UserSecurityService userSecurityService;
	
	@Bean
	JwtAuthenticationEntryPoint authEntryPoint() {
		return new JwtAuthenticationEntryPoint();
	}
	
	@Bean
	JwtTokenProvider tokenProvider() {
		return new JwtTokenProvider();
	}
	
	@Bean
	JwtAuthenticationFilter authFilter() {
		return new JwtAuthenticationFilter(userSecurityService,tokenProvider());
	}
	
	@Bean
	MvcRequestMatcher.Builder mvcBuilder(HandlerMappingIntrospector introspector){
		return new MvcRequestMatcher.Builder(introspector);
	}
	
	@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		    .exceptionHandling(exp -> exp.authenticationEntryPoint(authEntryPoint()))
			.cors(cors -> cors.configurationSource(corsConfigurationSource()))
			.csrf(csrf -> csrf.disable())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.securityMatcher("/api/**")
			.authorizeHttpRequests(auth -> 
				auth
				.requestMatchers("/api/image/*/*.jpg").permitAll()
				.requestMatchers("/api/otp/**").permitAll()
				.requestMatchers("/api/movie/all").permitAll()
				.requestMatchers("/api/movie/{movieId:[0-9]+}").permitAll()
				.requestMatchers("/api/cinema/all").permitAll()
				.requestMatchers("/api/cinema/{cinemaId:[0-9]+}").permitAll()
				.requestMatchers("/api/theater/all").permitAll()
				.requestMatchers("/api/theater/{theaterId:[0-9]+}").permitAll()
				.requestMatchers("/api/theater/{cinemaId:[0-9]+}/find").permitAll()
				.requestMatchers("/api/user/create").permitAll()
				.requestMatchers("/api/user/login").permitAll()
				.requestMatchers("/api/user/all").hasRole("ADMIN")
				.requestMatchers("/api/user/{userId:[0-9]+}").hasRole("ADMIN")
				.requestMatchers("/api/user/{userId:[0-9]+}/role").hasAnyRole("USER","ADMIN")
				.requestMatchers("/api/user/update").hasRole("ADMIN")
				.requestMatchers("/api/user/{userId:[0-9]+}/enable").hasRole("ADMIN")
				.requestMatchers("/api/user/{userId:[0-9]+}/delete").hasRole("ADMIN")
				.requestMatchers("/api/movie/create").hasRole("ADMIN")
				.requestMatchers("/api/movie/update").hasRole("ADMIN")
				.requestMatchers("/api/cinema/create").hasRole("ADMIN")
				.requestMatchers("/api/cinema/update").hasRole("ADMIN")
				.requestMatchers("/api/cinema/{cinemaId:[0-9]+}/delete").hasRole("ADMIN")
				.requestMatchers("/api/theater/{cinemaId:[0-9]+}/create").hasRole("ADMIN")
				.requestMatchers("/api/theater/{cinemaId:[0-9]+}/update").hasRole("ADMIN")
				.requestMatchers("/api/theater/{theaterId:[0-9]+}/delete").hasRole("ADMIN")
				.requestMatchers("/api/movie/{movieId:[0-9]+}/addgenere").hasRole("ADMIN")
				.requestMatchers("/api/movie/{movieId:[0-9]+}/addcrew").hasRole("ADMIN")
				.requestMatchers("/api/movie/time/{showTimeId:[0-9]+}").hasRole("ADMIN")
				.requestMatchers("/api/movie/{movieId:[0-9]+}/delete").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
			.authenticationProvider(daoProvider())
			.addFilterBefore(authFilter(),UsernamePasswordAuthenticationFilter.class);
			
		return http.build();
	}
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}
	
	@Bean
	DaoAuthenticationProvider daoProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userSecurityService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.setAllowedOrigins(Arrays.asList("*"));
	    configuration.setAllowedMethods(Arrays.asList("*"));
	    configuration.setAllowedHeaders(Arrays.asList("*"));
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}


}
