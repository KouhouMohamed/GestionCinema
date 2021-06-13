package com.kouhou.jee.Service;

import com.kouhou.jee.entities.User;
import com.kouhou.jee.entities.VerificationToken;
import com.kouhou.jee.request.LoginRequest;
import com.kouhou.jee.request.RegisterRequest;


public interface AuthService {

	public String signup(RegisterRequest registerRequest);

	//public String generateVerificationToken(User user);
	
	public void verifyAccount(String token);

	public String login(LoginRequest loginRequest);
}
