package com.m2i.secu.auth;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;


@Component
public class SecurityUtil {

	
	String TOKEN_KEY = "secret-token";
	Long EXPIRATION_DATE = (long) (60*60*1000);
	
	@Autowired
	UsersRepository userRepo;
	
	
	public String encryptPassword(String password) {
		return "**"+password+"**(is encoded)";
	}
	
	public String createToken(Users u) {
		
		return Jwts.builder()
				.setSubject( u.getEmail() ) 
				.setIssuer("M2i")
				.setIssuedAt(new Date())
				.setExpiration(new Date( System.currentTimeMillis() +  EXPIRATION_DATE  ))
				.signWith( SignatureAlgorithm.HS512 , TOKEN_KEY)
				.compact();
	}

	public boolean isValidToken(String token) { 
		
		
		String[] tokenSplited = token.split(" ");
		
		try {
			
			if (tokenSplited[0].equals("Bearer") ) {
				Jwts.parser().setSigningKey(TOKEN_KEY).parseClaimsJws(tokenSplited[1]);
				return true;				
			}
			
		} catch (ExpiredJwtException e) {
			System.out.println("JWT Expired");
		} catch (UnsupportedJwtException e) {
			System.out.println("JWT Unsupported");
		} catch (MalformedJwtException e) {
			System.out.println("JWT is invalid");
		} catch (SignatureException e) {
			System.out.println("JWT Signature validation failed");
		} catch ( IllegalArgumentException e) {
			System.out.println("JWT is Null, empty, contain space");
		}
		
		
		return false;
	}
	
	
	
	
}
