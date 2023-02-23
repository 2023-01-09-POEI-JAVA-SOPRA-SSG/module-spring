package com.m2i.JPAMessenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.JPAMessenger.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {

	@Autowired
	MessageService service;
}

