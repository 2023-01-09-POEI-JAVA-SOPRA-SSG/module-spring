package com.m2i.JPAMessenger.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.JPAMessenger.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{		
	 //4 Récupérer tout les messages avec une pagination et un trie par date croissant:
	Page<Message> findAll(Pageable p);
	
	 //5 Récupérer tout les messages avec une pagination et un trie par date croissant, tel que le destinataire est envoyé un parametre:
	Page<Message> findByDestEmail(String destEmail, Pageable p);
}
