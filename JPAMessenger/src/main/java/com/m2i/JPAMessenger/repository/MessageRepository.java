package com.m2i.JPAMessenger.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.m2i.JPAMessenger.entity.Message;
import com.m2i.JPAMessenger.model.Content;

public interface MessageRepository extends JpaRepository<Message, Integer>{		
	 //4 Récupérer tout les messages avec une pagination et un trie par date croissant:
	Page<Message> findAll(Pageable p);
	
	 //5 Récupérer tout les messages avec une pagination et un trie par date croissant, tel que le destinataire est envoyé un parametre:
	Page<Message> findByDestEmail(String destEmail, Pageable p);
	
	
	//6 Récupérer tout les message du emailDestinataire 'toto'
	@Query(value = "SELECT m FROM Message m WHERE m.destEmail = 'Candida Klocko' ")
	List<Message> findByEmailDest();
	
    //7 Récupérer une liste de String de tout les contenues de messages;
	@Query(value = "SELECT m.content FROM Message m")
    List<String> findContent();
	
	//8 Récupérer une liste contenant les attributs content et date de tout les messages
	
	@Query(value = "SELECT new com.m2i.JPAMessenger.model.Content(m.content, m.date) FROM Message m")
	List<Content> getDateAndContent();
	
	
	
}
