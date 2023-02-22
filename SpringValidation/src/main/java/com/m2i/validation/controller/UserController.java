package com.m2i.validation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.validation.entity.User;
import com.m2i.validation.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	UserService service;
	
	
	@GetMapping
	public List<User> getAllUsers(){
		return service.getAll();
	}
	
	
	@PostMapping
	public void newUser(@RequestBody @Valid User u  ) {
		service.addUser(u);
	}
	
	
	
	
	
	
}
