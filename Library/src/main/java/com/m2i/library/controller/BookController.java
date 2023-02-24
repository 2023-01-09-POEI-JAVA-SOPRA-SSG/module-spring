package com.m2i.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.library.entity.Book;
import com.m2i.library.repository.BookRepository;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookRepository bRepo;
	
	
	
	//1. localhost:8080/book/edition/{nameEdition} -> Revoie le nom de tout les livres de cette edition
	@GetMapping("/edition/{nameEdition}") 
	List<Book> getBookByEdition(@PathVariable("nameEdition") String edition){
		return bRepo.findByEdition(edition);
	}
	
	// 4. localhost:8080/book/all/{page}/{size} -> Renvoie les livres avec une pagination et trié par titre
	@GetMapping("/all/{page}/{size}")
	Page<Book> findAllWithSortedPagination(@PathVariable("page") int page, @PathVariable("size") int size){
		return bRepo.findAll(PageRequest.of(page, size, Sort.by("title").ascending()));
	}
	
	// 6. localhost:8080/book/vente/{quantity} -> Renvoie tout les livres ayant plus de 'quantity' ventes 
	@GetMapping("/ventes/{quantity}")
	public List<Book> getBestSellers(@PathVariable("quantity") int quantity){
		return bRepo.findByVentesGreaterThan(quantity);
	}
	

	
	
}
