package com.m2i.dao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.dao.entity.Author;
import com.m2i.dao.entity.Video;
import com.m2i.dao.service.AuthorService;



@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	AuthorService aService;
	
	@GetMapping("/fake/{videos}")
	public Author fakeAuthor( @PathVariable("videos") int nbVideos ) {
		Author a = new Author();
		
		for (int i = 0; i < nbVideos; i++) {
			a.getVideos().add( new Video(a));
		}
		aService.create(a);
		return a;
	}
	
	@GetMapping("/{id}/nbVues")
	public int getVuesByAuthor(@PathVariable("id") int id) {
		return aService.getById(id).getVideos().stream().map(x -> x.getNbVue()).reduce(0, Integer::sum);
	}
	
	@GetMapping("/{id}")
	public Author getAuthorById(@PathVariable("id") int id) {
		return aService.getById(id);
	}
	
	@GetMapping
	public List<Author> getAll(){
		return aService.getAll();
	}
	
	@PostMapping
	public void postAuthor(@RequestBody Author a) {
		aService.create(a);
	}
	
	@PutMapping("/{id}")
	public void putAuthor(@PathVariable("id") int id,@RequestBody Author a) {
		aService.update(id, a);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEleve(@PathVariable("id") int id) {
		aService.delete(id);
	}
	
}
