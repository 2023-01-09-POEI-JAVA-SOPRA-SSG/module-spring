package com.m2i.dao.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity @Table
@Getter @Setter @AllArgsConstructor
public class Author {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String pseudo;
	
	private int nbAbonnee;
	
	private String description;
	
	@OneToMany( targetEntity=Video.class, mappedBy="author" , cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
    private List<Video> videos = new ArrayList<>();
	
	public Author() {
		Faker f = new Faker();
		
		this.pseudo = f.name().username();
		
		this.nbAbonnee = f.number().numberBetween(0, 1000000);
		
		this.description = f.lorem().characters(200, 240);
		
	}
}
