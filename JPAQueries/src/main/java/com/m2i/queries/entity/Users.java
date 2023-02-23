package com.m2i.queries.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
public class Users {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String email;
	
	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_user_id", referencedColumnName = "id")
	private List<Product> products;

	public Users(Faker f) {
				
		this.name = f.name().fullName();
		this.products = new ArrayList<>();
		this.email = f.internet().emailAddress();
	}
	
	
}
