package com.m2i.queries.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.queries.service.UsersService;

@RestController
@RequestMapping("/product")
public class ProductController {


	@Autowired
	UsersService service;
}
