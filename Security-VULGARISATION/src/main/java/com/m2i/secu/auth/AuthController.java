package com.m2i.secu.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	SecurityUtil securityUtil;
	
	@Autowired
	UsersRepository usersRepository;
	
	
	@PostMapping("/signup")
	public void CreateAccount(@RequestBody Users u) {
		
		String encodedPassword = securityUtil.encryptPassword(u.getPassword());
		u.setPassword( encodedPassword );
		usersRepository.save(u);
	}
	
	
	@PostMapping("/login")
	public String login(@RequestBody Credentials credentials) {
		
		Users u = usersRepository.findByEmail( credentials.getEmail() ).orElse(null);
		
		if (u != null) {
			String passwordEncoded = securityUtil.encryptPassword( credentials.getPassword() );
			
			if (u.getPassword().equals(passwordEncoded)) {
				
				return securityUtil.createToken(u);
				
			}
		}
		
		
		
		return "BAD CREDENTIALS";
	}
	
	
	
	
	
}
