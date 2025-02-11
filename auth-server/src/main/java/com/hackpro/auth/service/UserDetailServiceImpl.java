package com.hackpro.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hackpro.auth.model.User;
import com.hackpro.auth.model.UserDetailsPrincipal;
import com.hackpro.auth.repository.UserDetailRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailRepository userDetailRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userDetailRepository.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("Username or Password Wrong"));
		UserDetails userDetails = new UserDetailsPrincipal(user.get());
		new AccountStatusUserDetailsChecker().check(userDetails);
		return userDetails;
	}

}
