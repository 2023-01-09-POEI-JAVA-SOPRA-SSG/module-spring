package com.m2i.library.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BooksAndAuthorNamesV2 {
	
	String authorName;
	
	List<String> booksName;
	
	public BooksAndAuthorNamesV2(String author) {
		this.authorName = author;
		
		this.booksName = new ArrayList<>();
				
	}
	

}
