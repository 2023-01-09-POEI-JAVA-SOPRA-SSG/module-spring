package com.m2i.JPAMessenger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.JPAMessenger.entity.Users;
import com.m2i.JPAMessenger.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	
	@GetMapping("/mail")
	public Users getByEmail(@RequestParam("email") String email) {
		
		return service.findByEmail(email);
		
	}
	
	
	@GetMapping("/firstname")
	public List<Users> getByFirstName( @RequestParam("firstname") String firstname  ){
		return service.findByFirstName(firstname);
	}
	
	
	@GetMapping("/namelike")
	public List<Users> getByFirstNameList( @RequestParam("firstname") String firstname  ){
		return service.findByFirstNameLike(firstname);
	}
	
	
	
}
