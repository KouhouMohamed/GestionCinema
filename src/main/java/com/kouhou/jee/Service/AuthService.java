<<<<<<< HEAD
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
=======
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
>>>>>>> be89fbdb7b30a47a15d68d0a2dc31901a4e62c48
