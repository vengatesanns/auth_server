package com.hackpro.auth.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsPrincipal extends User implements UserDetails {

	
	public UserDetailsPrincipal() {
	}

	public UserDetailsPrincipal(User user) {
		super(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantAuthority = new ArrayList<>();
		super.getRoles().forEach(roles -> {
			grantAuthority.add(new SimpleGrantedAuthority(roles.getName()));
			roles.getPermissions().forEach(per -> {
				grantAuthority.add(new SimpleGrantedAuthority(per.getName()));
			});
		});
		return grantAuthority;
	}

	@Override
	public String getPassword() {

		return super.getPassword();
	}

	@Override
	public String getUsername() {

		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {

		return super.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {

		return super.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return super.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {

		return super.isEnabled();
	}

}
