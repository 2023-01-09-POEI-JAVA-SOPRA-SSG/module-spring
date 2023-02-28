package com.example.tpsecurity.auth;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.tpsecurity.entity.Users;
import com.example.tpsecurity.model.Credential;
import com.example.tpsecurity.repository.RoleRepository;
import com.example.tpsecurity.repository.UsersRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class SecurityUtil {

	@Autowired
	UsersRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	
	
	private final String SECRET_TOKEN = "token-super-secret";
	private final Long EXPIRATION_DATE = (long) (15 * 60 * 1000);
	
	
	public String encodePassword(String password) {
		return "*{" + password + "}* : encoded";
	}
	
	public Users getUserByCredentials(Credential credential) {
		
		return userRepo.findByEmailAndPassword( 
					credential.getEmail(),
					encodePassword( credential.getPassword() )
				)
				.orElse(null);
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

	public boolean isValidToken(String bearerToken) {
		try {
			String token = getTokenFromBearerToken(bearerToken);
			Jwts.parser().setSigningKey(SECRET_TOKEN).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String getTokenFromBearerToken(String bearerToken) throws Exception {
		
		if ( bearerToken.startsWith("Bearer ") ) {
			return bearerToken.split(" ")[1];
		}
		
		throw new Exception("INVALID TOKEN");
	}

	public Users getUserFromToken(String bearerToken) {
		try {
			String token = getTokenFromBearerToken(bearerToken);
			String email = getSubject(token);
			Users user = userRepo.findByEmail(email).orElseThrow();
			
			return user;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String getSubject(String token) {
		return parseClaims(token).getSubject();
	}
	
	public Claims parseClaims(String token) {
		return Jwts.parser()
				.setSigningKey(SECRET_TOKEN)
				.parseClaimsJws(token)
				.getBody();
	}
	
	public boolean canAcces(String bearerToken, String role) {
		String token;		
		try {
			token = getTokenFromBearerToken(bearerToken);
			String email = getSubject(token);
			return roleRepo.findRoleByEmailAndType(email, role).isPresent();
		} catch (Exception e) {
			return false;
		}
		
	}	
}
