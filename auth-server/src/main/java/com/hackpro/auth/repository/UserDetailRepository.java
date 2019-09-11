package com.hackpro.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackpro.auth.model.User;

public interface UserDetailRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);

}
