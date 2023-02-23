package com.m2i.queries.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.m2i.queries.entity.Product;
import com.m2i.queries.repository.ProductRepository;
import com.m2i.queries.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {


	@Autowired
	ProductService service;
	
	@Autowired
	ProductRepository repo;
	
	
	@PostMapping("/fake")
	public void fake() {
		List<Product> pl = new ArrayList<>();
		
		Faker f = new Faker();
		for (int i = 0; i < 100; i++) {
			pl.add( new Product(f));
		}
		
		repo.saveAll(pl);
	}
	
	
}
