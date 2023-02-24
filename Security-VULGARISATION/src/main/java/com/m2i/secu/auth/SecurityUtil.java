package com.m2i.secu.auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {

	
	String TOKEN_KEY = "secret-token";
	Long TOKEN_VALIDITY = (long) (60*60*1000);
	
	@Autowired
	UsersRepository userRepo;
	
	
	public String encryptPassword(String password) {
		return password + ":encoded";
	}
	
	public String createToken(Users u) {
		return u.getEmail() +":"+ TOKEN_KEY +":"+ TOKEN_VALIDITY;
	}

	public boolean isValidToken(String token) {
		
		String[] tokenSplited = token.split(":");
		
		Users u = userRepo.findByEmail( tokenSplited[0] ).orElse(null);
		
		return u!= null && tokenSplited[1].equals(TOKEN_KEY);
	}
	
	
	
	
}
