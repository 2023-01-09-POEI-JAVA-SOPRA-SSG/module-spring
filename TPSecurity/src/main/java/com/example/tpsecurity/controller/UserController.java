package com.example.tpsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tpsecurity.auth.SecurityUtil;
import com.example.tpsecurity.entity.Users;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	SecurityUtil securityUtil;
	
	
	@GetMapping("/hello")
	public String helloWorld(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token) {
				
		if (securityUtil.isValidToken(token) && securityUtil.getUserFromToken(token) != null) {
			return "Hello World";
		}
		
		return "BAD TOKEN";
	}
	
	
}
