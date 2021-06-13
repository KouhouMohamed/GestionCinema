package com.kouhou.jee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kouhou.jee.Service.AuthService;
import com.kouhou.jee.request.LoginRequest;
import com.kouhou.jee.request.RegisterRequest;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private AuthService authService;
	
	@PostMapping(path = "/signup")
	public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
		String message = authService.signup(registerRequest);
		return new ResponseEntity<>("User Registration successfuly\nPlease visite "+message+" to activate your account",HttpStatus.OK);
	}

	@GetMapping("/accountVerification/{token}")
	public ResponseEntity<String> verifyAccount(@PathVariable String token){
		authService.verifyAccount(token);
		return new ResponseEntity<String>("Accoun activated successfuly",HttpStatus.OK);
	}
	@GetMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest ) {
		String message = authService.login(loginRequest);
		return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
}
