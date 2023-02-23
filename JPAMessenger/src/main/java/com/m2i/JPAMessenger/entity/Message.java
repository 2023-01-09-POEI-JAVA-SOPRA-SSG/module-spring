package com.m2i.JPAMessenger.entity;

import java.util.Date;

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
public class Message {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date date;
	
	private String destEmail;
	
	private String content;
	
	public Message(Faker f) {
		this.date = f.date().birthday();
		this.destEmail = f.name().fullName();
		this.content = f.lorem().characters(150);
	}
	
}
