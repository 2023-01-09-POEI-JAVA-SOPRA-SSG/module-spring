package com.m2i.JPAMessenger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.m2i.JPAMessenger.entity.Message;
import com.m2i.JPAMessenger.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository repo;
	
	
	public Page<Message> findAllWithPagination(int page, int size){
		Sort sort = Sort.by("date").ascending();
		Pageable p = PageRequest.of(page,size, sort);
		
		return repo.findAll(p);
	}
	
	public Page<Message> findDestEmailWithPagination(int page, int size, String destEmail){
		Sort sort = Sort.by("date").ascending();
		Pageable p = PageRequest.of(page,size, sort);
		
		
		return repo.findByDestEmail(destEmail, p);
	}
	
	
}
