package com.kouhou.jee.ServiceImpl;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kouhou.jee.Exception.MyException;
import com.kouhou.jee.Service.AuthService;
import com.kouhou.jee.Service.MailService;
import com.kouhou.jee.entities.NotificationEmail;
import com.kouhou.jee.entities.Role;
import com.kouhou.jee.entities.User;
import com.kouhou.jee.entities.VerificationToken;
import com.kouhou.jee.repositories.RoleRepository;
import com.kouhou.jee.repositories.TokenRepository;
import com.kouhou.jee.repositories.UserRepository;
import com.kouhou.jee.request.LoginRequest;
import com.kouhou.jee.request.RegisterRequest;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenRepository tokenRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public String signup(RegisterRequest registerRequest) {
		User user = new User();
		
		user.setEmail(registerRequest.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		user.setUsername(registerRequest.getUsername());
		user.setEnabled(false);
		Set<Role> roles = new HashSet<Role>();
		Role role = roleRepository.findByLabel("USER");
		user.setRoles(roles);
		
		userRepository.save(user);
		
		String token = generateVerificationToken(user);
		/*mailService.sendEmail(new NotificationEmail(null,"Activate WatchIt account",
				user.getEmail(),"Thanks for your signin up 	to our platform please"+
		"click on the link below to activate your account \n"+
		"http://localhost:8080/api/auth/accountVerification/"+token));*/
		return "http://localhost:8080/api/auth/accountVerification/"+token;
	}

	private String generateVerificationToken(User user) {

		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken(null,token, user);
		tokenRepository.save(verificationToken);
		
		return token;
	}
	
	@Override
	public void verifyAccount(String token){

		VerificationToken verificationToken =  tokenRepository.findByToken(token);
		if(verificationToken==null)
			throw new MyException("No verification found for this token");
		else{
			fetchUserAndEnable(verificationToken);
			tokenRepository.delete(verificationToken);
		}
	}

	private void fetchUserAndEnable(VerificationToken verificationToken) {
		
		String username = verificationToken.getUser().getUsername();
		User user = userRepository.findByUsername(username);
		if(user==null)
			throw new MyException("No user found for with name "+username);
		else {
			user.setEnabled(true);	
			userRepository.save(user);
			
		}
		
	}

	@Override
	public String login(LoginRequest loginRequest) {
		User user = userRepository.findByEmail(loginRequest.getEmail());
		String password;
		if(user == null)
			throw new MyException("No user with this email is founded");
		else {
			password = passwordEncoder.encode(loginRequest.getPassword());
			if(!user.isEnabled())
				return "Please activate your account and try again";
			else {
				if(password.equals(user.getPassword()))
					return "Login Successfuly";
				else
					return "Failed Login";
			}
		}
			
		
	}
}
