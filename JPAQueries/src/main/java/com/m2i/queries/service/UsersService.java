package com.m2i.queries.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.m2i.queries.entity.Users;
import com.m2i.queries.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	UsersRepository userRepo;
	
	
	
	public Users findById(int id) {
		return userRepo.findById(id).orElse(null);
		
	}
	
	public Users findExactUser(String email, String name) {
		return userRepo.findByEmailAndName(email, name).orElse(null);
	}
	
	public Users findByEmail(String email) {
		return userRepo.findByEmail(email).orElse(null);
	}
	
	public List<Users> findByEmailIsNot(String email) {
		return userRepo.findByEmailIsNot(email);
	}
	
	public Page<Users> findAllWithPagination(int page, int nombre){
		Sort sort = Sort.by("email").ascending();

		Pageable pageable = PageRequest.of(page, nombre, sort);
		
		
		
		return userRepo.findAll( pageable );
	}
	
	
	
}
