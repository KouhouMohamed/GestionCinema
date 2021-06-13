<<<<<<< HEAD
package com.kouhou.jee.security.authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kouhou.jee.entities.User;
import com.kouhou.jee.repositories.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService{

	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		UserPrincipal userPrincipal = new UserPrincipal(user);
		if(user == null) {
			throw new UsernameNotFoundException("A user with name "+username+" not found");
			
		}
		return userPrincipal;
	}

}
=======
package com.kouhou.jee.security.authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kouhou.jee.entities.User;
import com.kouhou.jee.repositories.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService{

	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		UserPrincipal userPrincipal = new UserPrincipal(user);
		if(user == null) {
			throw new UsernameNotFoundException("A user with name "+username+" not found");
			
		}
		return userPrincipal;
	}

}
>>>>>>> be89fbdb7b30a47a15d68d0a2dc31901a4e62c48
