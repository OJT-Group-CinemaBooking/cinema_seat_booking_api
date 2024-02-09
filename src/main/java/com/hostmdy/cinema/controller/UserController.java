package com.hostmdy.cinema.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.cinema.config.JwtTokenProvider;
import com.hostmdy.cinema.domain.User;
import com.hostmdy.cinema.payload.LoginRequest;
import com.hostmdy.cinema.payload.LoginResponse;
import com.hostmdy.cinema.payload.UserAlreadyExistsExceptionResponse;
import com.hostmdy.cinema.payload.UserRoleResponse;
import com.hostmdy.cinema.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@CrossOrigin("http://localhost:3000")
public class UserController {
	
	private final static String TOKEN_PREFIX = "Bearer ";

	private final UserService userService;
	private final AuthenticationManager authManager;
	private final JwtTokenProvider tokenProvider;

	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> usersList = userService.getAllUsers();
		if (usersList.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usersList);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Long userId) {
		Optional<User> userOptional = userService.getUserById(userId);
		if (userOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userOptional.get());
	}
	
	@GetMapping("/{userId}/role")
	public ResponseEntity<UserRoleResponse> getUserWithRoles(@PathVariable Long userId){
		Optional<User> userOptional = userService.getUserById(userId);
		if(userOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		User user = userOptional.get();
		
		List<String> roles = user.getUserRoles().stream()
				.map(ur -> ur.getRole().getName()).toList();
		return ResponseEntity.ok(new UserRoleResponse(user,roles));
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
		String username = loginRequest.getUsername();
		Authentication authentication = authManager.authenticate(
			new UsernamePasswordAuthenticationToken(username, loginRequest.getPassword())	
				);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		Optional<User> userOptional = userService.getUserByEmail(username);
		User user =  userOptional.isPresent()? userOptional.get()  : userService.getUserByUsername(username).get();

		List<String> roles = user.getUserRoles().stream()
				.map(ur -> ur.getRole().getName()).toList();
		
		String token = TOKEN_PREFIX+tokenProvider.generateToken(authentication);
		
		return ResponseEntity.ok(new LoginResponse(token,user,roles,true));
	}

	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		if(userService.isUsernameExists(user.getUsername())) {
			return ResponseEntity.status(403).body(new UserAlreadyExistsExceptionResponse("username already exists"));
		}
		if(userService.isEmailExists(user.getEmail())) {
			return ResponseEntity.status(403).body(new UserAlreadyExistsExceptionResponse("email already exists"));
		}
		return ResponseEntity.status(200).body(userService.createUser(user));
	}

	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		if (user.getId() == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.status(201).body(userService.saveUser(user));
	}

	@DeleteMapping("/{userId}/delete")
	public ResponseEntity<Long> deleteUser(@PathVariable Long userId) {
		Optional<User> userOptional = userService.getUserById(userId);
		if (userOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		userService.deleteUserById(userId);
		return ResponseEntity.ok(userId);
	}

}
