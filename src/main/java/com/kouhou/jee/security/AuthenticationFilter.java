package com.kouhou.jee.security;

import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class AuthenticationFilter extends BasicAuthenticationFilter{

	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}
	
	

}
