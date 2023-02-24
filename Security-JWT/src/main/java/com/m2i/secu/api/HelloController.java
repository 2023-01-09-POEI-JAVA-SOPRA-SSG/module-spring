package com.m2i.secu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.secu.auth.SecurityUtil;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

	@Autowired
	SecurityUtil securityUtil;
	
	
	@GetMapping("/hello")
	String helloWorld(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token ) {
		if (securityUtil.isValidToken(token) ) {
			return "Hello World";
		} else {
			return "BAD TOKEN";			
		}
	}
}
