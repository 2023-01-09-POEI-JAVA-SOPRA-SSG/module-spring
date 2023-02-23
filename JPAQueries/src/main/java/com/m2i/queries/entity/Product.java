package com.m2i.queries.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter @Setter //= @Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int quantity;
	
	private int price;
	
	public Product(Faker f) {
		this.name = f.app().name();
		this.quantity = f.number().numberBetween(1, 100);
		this.price = f.number().numberBetween(10, 1000);
	}
	
	
}
