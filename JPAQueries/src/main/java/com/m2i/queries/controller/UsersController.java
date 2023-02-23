package com.m2i.queries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.m2i.queries.entity.Users;
import com.m2i.queries.repository.UsersRepository;
import com.m2i.queries.service.UsersService;

@RestController
@RequestMapping("/user")
public class UsersController {

	@Autowired
	UsersService service;
	
	@Autowired
	UsersRepository repo;
	
	
	
	@GetMapping("/mail/{mail}")
	public Users getByEmail(@PathVariable("mail") String mail) {
		return service.findByEmail(mail);
	}
	
	
	@GetMapping("/mailnot/{mail}")
	public List<Users> getByEmailIsNot(@PathVariable("mail") String mail) {
		return service.findByEmailIsNot(mail);
	}
	
	@GetMapping("/exact")
	public Users exact(@RequestParam("email") String email, @RequestParam("name") String name) {
		return service.findExactUser(email, name);
	}
	
	
	@PostMapping("/fake/{number}")
	public void createFakeUsers(@PathVariable("number") int number) {
		Faker f = new Faker();
		for (int i = 0; i < number; i++) {
			this.repo.save( new Users(f) );
		}
	}
	
	@GetMapping("/all")
	public List<Users> getAll(){
		return this.repo.findAll();
	}
	
	@GetMapping("/all/{page}/{size}")
	public Page<Users> getByPage(@PathVariable("page") int page, @PathVariable("size") int size){
		return service.findAllWithPagination(page, size);
	}
	
	
}
