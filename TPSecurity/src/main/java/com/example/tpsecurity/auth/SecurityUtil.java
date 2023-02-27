package com.example.tpsecurity.auth;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.tpsecurity.entity.Users;
import com.example.tpsecurity.model.Credential;
import com.example.tpsecurity.repository.UsersRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class SecurityUtil {

	@Autowired
	UsersRepository userRepo;
	
	private final String SECRET_TOKEN = "token-super-secret";
	private final Long EXPIRATION_DATE = (long) (15 * 60 * 1000);
	
	
	public String encodePassword(String password) {
		return "*{" + password + "}* : encoded";
	}
	
	public Users getUserByCredentials(Credential credential) {
		
		return userRepo.findByEmailAndPassword( 
				credential.getEmail(),
				encodePassword( credential.getPassword() )
				).orElse(null);
	}
	
	public String createToken(Users user) {
				
		return Jwts.builder()
				.setSubject( user.getEmail())
				.setIssuer("C'est moi")
				.setIssuedAt( new Date() )
				.setExpiration( new Date( System.currentTimeMillis() + EXPIRATION_DATE))
				.signWith( SignatureAlgorithm.HS512, SECRET_TOKEN )
				.compact();
	}
	
	
	
}
