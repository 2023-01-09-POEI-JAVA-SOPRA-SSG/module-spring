package com.example.tpsecurity.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@ToString
public class Users {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName;

	private String lastName;
	
	private String email;

	private String password;

	@JsonIgnore
	@ManyToMany(targetEntity = Role.class)
	@JoinTable(
			name="user_role",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private List<Role> roles;

	@JsonIgnore
	@ManyToMany(targetEntity = Product.class)
	@JoinTable(
			name="user_product",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id")
			)
	private List<Product> products;
	
	
}
