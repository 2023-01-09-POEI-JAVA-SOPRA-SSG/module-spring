package com.m2i.library.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.library.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{
	// 1. localhost:8080/book/edition/{nameEdition} -> Revoie le nom de tout les livres de cette edition
	
	List<Book> findByEdition(String edition);
	
	// 4. localhost:8080/book/all/{page}/{size} -> Renvoie les livres avec une pagination et trié par titre
	Page<Book> findAll(Pageable p);
	
	// 6. localhost:8080/book/vente/{quantity} -> Renvoie tout les livres ayant plus de 'quantity' ventes 
	List<Book> findByVentesGreaterThan(int ventes);
	
	
}
