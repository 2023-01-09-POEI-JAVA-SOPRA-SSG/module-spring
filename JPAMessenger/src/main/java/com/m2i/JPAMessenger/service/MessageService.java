package com.m2i.JPAMessenger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.JPAMessenger.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository repo;
}
