package com.m2i.secu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
				
		if (securityUtil.isValidToken(token) && securityUtil.userInDb(token) ) {
			return "Hello World";
		} else {
			return "BAD REQUEST";			
		}
	}
	
	@GetMapping("/admin")
	String isAdmin(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token) {
		if (securityUtil.isValidToken(token) && securityUtil.userInDb(token) && securityUtil.haveRole(token, "ADMIN")) {
			return "Is Admin";
		} else {
			return "BAD REQUEST";			
		}
	}
	
	@GetMapping("/root")
	String isRoot(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token) {
		if (securityUtil.isValidToken(token) && securityUtil.userInDb(token) && securityUtil.haveRole(token, "ROOT")) {
			return "Is Root";
		} else {
			return "BAD REQUEST";			
		}
	}
	
}
