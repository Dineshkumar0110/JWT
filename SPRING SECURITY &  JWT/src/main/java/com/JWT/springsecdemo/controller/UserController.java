package com.JWT.springsecdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.JWT.springsecdemo.model.User;
import com.JWT.springsecdemo.service.UserService;
import com.JWT.springsecdemo.service.jwtService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@Autowired
	private jwtService jwtService;

	

	@Autowired
	AuthenticationManager authenticationManager;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
	  return service.saveUser(user);
	}
	


	 @PostMapping("/login")
	    public String login(@RequestBody User user) {
	        // Authentication manager and authentication provider
	        Authentication authentication = authenticationManager
	                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

	        if (authentication.isAuthenticated()) {
	            return jwtService.generateToken(user.getUsername());
	        } else {
	            return "Login Failed";
	        }
	    }

}
