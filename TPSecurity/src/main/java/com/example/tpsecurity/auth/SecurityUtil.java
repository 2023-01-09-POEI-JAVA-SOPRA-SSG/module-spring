package com.example.tpsecurity.auth;

import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {

	
	
	
	public String encodePassword(String password) {
		return "*{" + password + "}* : encoded";
	}
	
	
}
