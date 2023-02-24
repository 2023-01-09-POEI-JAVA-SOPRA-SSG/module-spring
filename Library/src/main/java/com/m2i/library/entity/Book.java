package com.m2i.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Book {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	 private String title;
     private int ventes;
     private int price;
     private String edition;
	
     
     
	public Book(Faker f) {
		this.title = f.name().title();
		this.ventes = f.number().numberBetween(1, 1000000);
		this.price = f.number().numberBetween(5, 50);
		this.edition = f.company().name();
	}
     
     
     

}
