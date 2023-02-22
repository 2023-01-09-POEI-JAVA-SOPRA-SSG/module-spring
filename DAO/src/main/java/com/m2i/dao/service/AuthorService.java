package com.m2i.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.dao.entity.Author;
import com.m2i.dao.repository.AuthorRepository;



@Service
public class AuthorService {

	@Autowired
	AuthorRepository repo;
	
	public void create(Author e) {
		repo.save(e);
	}

	public Author getById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<Author> getAll() {
		return repo.findAll();
	}

	public void update(int id, Author a) {
		Author author = repo.findById(id).orElse(null);
		if (a!= null) {
			author.setPseudo( a.getPseudo() );
			author.setDescription( a.getDescription());
			author.setNbAbonnee( a.getNbAbonnee());
			author.setVideos( a.getVideos() );
			repo.save(author);
		}
	}

	public void delete(int id) {
		Author author = repo.findById(id).orElse(null);
		if (author!= null) {
			repo.delete(author);
		}
		
	}

}
