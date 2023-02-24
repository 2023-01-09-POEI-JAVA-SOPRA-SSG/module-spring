package com.m2i.library.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.m2i.library.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{

	//2. localhost:8080/author/edition/{nameEdition} -> Revoie tout les author trié par nationalité
	List<Author> findAll(Sort s);
	
	//3. localhost:8080/author/all/{page}/{size} -> Renvoie les auteurs avec une pagination
	Page<Author> findAll(Pageable p);

	//5. localhost:8080/author/{name}/ventes -> Récupère la somme de tout les livre vendu d'un autheur
	@Query("SELECT SUM(b.ventes) FROM Author a JOIN a.books b WHERE a.name = ?1")
	Integer sommeBookSellingByAuthor(String name);
}

