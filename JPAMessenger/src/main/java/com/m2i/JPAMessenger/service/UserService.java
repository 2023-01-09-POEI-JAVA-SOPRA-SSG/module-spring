package com.m2i.JPAMessenger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.JPAMessenger.entity.Users;
import com.m2i.JPAMessenger.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	
	public Users findByEmail(String email) {
		
		return repo.findByEmail(email).orElse(null);
	}
	
	public List<Users> findByFirstName(String firstName){
		return repo.findByFirstName(firstName);
	}
	
	public List<Users> findByFirstNameLike(String firstName){
		return repo.findByFirstNameContaining(firstName);
	}
	
	
}
