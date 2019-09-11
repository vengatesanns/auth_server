package com.hackpro.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hackpro.auth.model.User;
import com.hackpro.auth.repository.UserDetailRepository;

public class UserDetailServiceImpl implements UserDetailsService {

	
	@Autowired
	private UserDetailRepository userDetailRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userDetailRepository.findByUsername(username);
		return null;
	}

}
