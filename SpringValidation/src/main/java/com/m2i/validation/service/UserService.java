package com.m2i.validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.validation.entity.User;
import com.m2i.validation.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	UserRepository repo;
	
	
	public List<User> getAll(){
		return repo.findAll();
	}
	
	
	public void addUser(User u) {
		repo.save(u);
	}
	
	
}
