package com.example.tpsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tpsecurity.auth.SecurityUtil;
import com.example.tpsecurity.entity.Users;
import com.example.tpsecurity.repository.UsersRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	UsersRepository uRepo;
	 
	@Autowired
	SecurityUtil securityUtil;
	
	
	@PostMapping("/signup")
	public void signup( @RequestBody Users user ) {
		user.setPassword(  securityUtil.encodePassword( user.getPassword() ));
		uRepo.save(user);
	}
	
	
	@GetMapping("/login")
	public String login() {
		
		return null;
	}
	
}
