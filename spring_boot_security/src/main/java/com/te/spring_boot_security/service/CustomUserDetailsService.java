package com.te.spring_boot_security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService{

	@Override
	//gets user details
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if (username.equals(username)) {
			
		}
		return null;
	}

}
