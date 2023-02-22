package com.m2i.validation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import org.hibernate.validator.constraints.Length;

@Entity @Table(name="T_User")
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@NotEmpty
	@Email
	@Column(unique = true, length = 255, nullable = false)
	private String email;
	
	@Length(min = 8, max = 64)
	private String password;
	
	
	@Min(value = 18)@Max(value = 100)
	@Positive
	public int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int id, String email, @Length(min = 8, max = 64) String password) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
	}

	public User(String email, @Length(min = 8, max = 64) String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public User() {
		super();
	}
	
	
	
}
