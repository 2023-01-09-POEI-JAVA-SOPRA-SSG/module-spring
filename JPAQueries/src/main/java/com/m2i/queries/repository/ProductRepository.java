package com.m2i.queries.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.queries.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
}
