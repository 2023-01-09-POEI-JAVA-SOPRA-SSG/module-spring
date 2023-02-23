package com.m2i.JPAMessenger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;
import com.m2i.JPAMessenger.entity.Message;
import com.m2i.JPAMessenger.model.Content;
import com.m2i.JPAMessenger.repository.MessageRepository;
import com.m2i.JPAMessenger.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	MessageService service;
	
	@Autowired
	MessageRepository repo;
	
	//  http://localhost:8080/message/fake/100
	@GetMapping("/fake/{number}")
	public void fakeMessage(@PathVariable("number") int number){
		Faker f = new Faker();
		for (int i =0; i<number; i++) {
			Message m = new Message(f);
			
			m.setDestEmail("java@jee.com");
			
			repo.save(m);
		}
	}
	
	@GetMapping("/all/{page}/{size}")
	public Page<Message> getAll(@PathVariable("page") int page, @PathVariable("size") int size){
		return service.findAllWithPagination(page,size);
	}
	
	@GetMapping("/dest/{page}/{size}")
	public Page<Message> getAll(@PathVariable("page") int page, @PathVariable("size") int size, @RequestParam("emailDest") String emailDest){
		return service.findDestEmailWithPagination(page, size, emailDest);
		
	}
	
	
    //6 Récupérer tout les message du emailDestinataire 'toto'
	@GetMapping("/toto")
	public List<Message> getAllMessageFromToto(){
		return repo.findByEmailDest();
	}
	
	
	
    //7 Récupérer une liste de String de tout les contenues de messages;
	@GetMapping("/contentString")
	public List<String> getAllContent(){
		return repo.findContent();
	}
	
	
    //8 Récupérer une liste contenant les attributs content et date de tout les messages
	@GetMapping("/content")
	public List<Content> getAllMessageContent(){
		return repo.getDateAndContent();
	}
	
}

