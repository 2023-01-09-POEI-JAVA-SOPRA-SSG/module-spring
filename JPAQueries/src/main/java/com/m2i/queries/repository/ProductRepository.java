package com.m2i.queries.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.m2i.queries.entity.Product;
import com.m2i.queries.model.ProductNamePrice;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
//	@Query(value = "SELECT * FROM Product WHERE id = 5")
	@Query(value = "SELECT p FROM Product p WHERE p.id = 5")
	Optional<Product> findId5();
	
//	@Query(value = "SELECT name FROM Product")
	@Query(value = "SELECT p.name FROM Product p")
	List<String> getProductNameList();
	
//	@Query(value = "SELECT name, price FROM Product", nativeQuery = true)	
	@Query(value = "SELECT new com.m2i.queries.model.ProductNamePrice(p.name, p.price) FROM Product p")
	List<ProductNamePrice> getProductNameAndPriceList();
}
