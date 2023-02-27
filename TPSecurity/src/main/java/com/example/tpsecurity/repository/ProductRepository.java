package com.example.tpsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tpsecurity.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
