package com.example.tpsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tpsecurity.auth.SecurityUtil;
import com.example.tpsecurity.entity.Product;
import com.example.tpsecurity.entity.Users;
import com.example.tpsecurity.repository.ProductRepository;
import com.example.tpsecurity.repository.UsersRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	SecurityUtil securityUtil;
	
	@Autowired
	ProductRepository pRepo;
	
	@Autowired
	UsersRepository uRepo;
	
	
	
	@GetMapping("/hello")
	public String helloWorld() {
				
		return "Hello World";
		
	}
	
	
	//     La route GET permet de récupérer tout vos produits
	
	@GetMapping("/product")
	public List<Product> getUserProducts( @RequestAttribute("email") String email){
		return uRepo.findByEmail(email).orElse(null).getProducts();
	}
	
	//    La route POST permet d'ajouter un produit à votre liste
	@PostMapping("/product")
	public Product addUserProducts( @RequestAttribute("email") String email, @RequestBody Product product ) {
		Users u = uRepo.findByEmail(email).orElse(null);
		if (u != null) {
			pRepo.save(product);
			u.getProducts().add(product);
			uRepo.save(u);
			return product;
		}
		return null;
	}
	
    //La route PUT permet de modifier vos informations utilisateur
    //La route PUT permet de modifier vos informations utilisateur
	@PutMapping
	public Users updateUser( @RequestAttribute("email") String email,@RequestBody Users u) {
		
		Users user = uRepo.findByEmail(email).orElse(null);
		
		if (user != null) {
			user.setEmail( u.getEmail() );
			user.setFirstName( u.getFirstName());
			user.setLastName( u.getLastName());
			user.setPassword( securityUtil.encodePassword( u.getPassword() )   );
			
			uRepo.save(user);
			return u;
		}
		return null;
	}
    //La route DELETE supprime votre compte (et donc vous ne pouvez plus faire de requêtes)
	@DeleteMapping
	public boolean deleteUser( @RequestAttribute("email") String email) {
		
		Users u = uRepo.findByEmail(email).orElse(null);
		if (u != null) {
			uRepo.delete(u);
			return true;
		}
		return false;
	}	
}
