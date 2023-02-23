package com.m2i.queries.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.queries.entity.Product;
import com.m2i.queries.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepo;
	
	
	
	public Product getById(int id) {
		return null;
	}
}
