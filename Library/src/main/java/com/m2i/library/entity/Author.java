package com.m2i.library.entity;

import java.util.ArrayList;
import java.util.Date;
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
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Author {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	 private String name;
     private Date birthDay;
     private String nationality;
     
     @OneToMany(targetEntity = Book.class, cascade = CascadeType.ALL)
     @JoinColumn(name = "fk_ba", referencedColumnName = "id")
     private List<Book> books;
     
     public Author(Faker f) {
    	 this.name = f.name().fullName();
    	 this.birthDay = f.date().birthday();
    	 this.nationality = f.nation().nationality();
    	 this.books = new ArrayList<>();
     }
     
     
     
	
}
