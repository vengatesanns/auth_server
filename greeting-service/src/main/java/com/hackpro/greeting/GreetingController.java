package com.hackpro.greeting;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	
	@GetMapping("/hello")
	@PreAuthorize("hasAuthority('ROLE_admin')")
	public String getGreetingMessage1()
	{
		return "Hello, Welcome to First Level Security";
	}
	
	
	@GetMapping("/hi")
	@PreAuthorize("hasAuthority('read_profile')")
	public String getGreetingMessage2()
	{
		return "Hello, Welcome to Second Level Security";
	}
}
