package com.m2i.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.Faker;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table 
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Video {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Getter @Setter
	private String url;
	@Getter @Setter
	private int duree;
	@Getter @Setter
	private int nbVue;
	@Getter @Setter
	private String title;
	@Getter @Setter
	private String description;
	@Getter @Setter
	private Date datePublication;
	
	@ManyToOne @JoinColumn(name="id_author")	
	@JsonIgnore
	private Author author;
	
	public Video(Author a) {
		Faker f = new Faker();
		
		this.author = a;
				
		this.url = f.internet().url();
		this.duree = f.number().numberBetween(60*2, 60*20);
		this.nbVue = f.number().numberBetween(0, 1000000);
		this.title = f.name().title();
		this.description = f.lorem().characters(240);
		this.datePublication = f.date().birthday();
	}
	
	
	
}
