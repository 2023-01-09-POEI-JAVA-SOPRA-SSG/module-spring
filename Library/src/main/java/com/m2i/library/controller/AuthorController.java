package com.m2i.library.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.m2i.library.entity.Author;
import com.m2i.library.entity.Book;
import com.m2i.library.repository.AuthorRepository;
import com.m2i.library.repository.BookRepository;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	AuthorRepository aRepo;
	
	@Autowired
	BookRepository bRepo;
	
	
	@PostMapping("/fake")
	public List<Author> fakeUsers(){
		List<Author> authors = new ArrayList<>();
		Faker f = new Faker();
		Random r = new Random();
		
		
		for(int i = 0; i < 100; i++) {
			
			Author author = new Author(f);
			aRepo.save(author);
			
			for (int j = 0; j < r.nextInt(10); j++) {
				Book b = new Book(f);
				author.getBooks().add(b);
				bRepo.save(b);
			}
			authors.add(author);
			
		}

		return authors;
	}
	
	
	//2. localhost:8080/author/sort/nationality -> Revoie tout les author trié par nationalité
	@GetMapping("/sort/nationality")
	List<Author> findAllSorted(){
		
		Sort s = Sort.by("nationality").ascending();
		return aRepo.findAll(s);
	}
	
	//3. localhost:8080/author/all/{page}/{size} -> Renvoie les auteurs avec une pagination
	@GetMapping("/all/{page}/{size}")
	Page<Author> findAllWithPagination(@PathVariable("page") int page, @PathVariable("size") int size){
		return aRepo.findAll(PageRequest.of(page, size));
	}
	
	//5. localhost:8080/author/{name}/ventes -> Récupère la somme de tout les livre vendu d'un autheur
	@GetMapping("/{name}/ventes")
	Integer getNumberOfSellsByAuthor(@PathVariable("name") String authorName) {
		return aRepo.sommeBookSellingByAuthor(authorName);
	}
	
	
	
}
