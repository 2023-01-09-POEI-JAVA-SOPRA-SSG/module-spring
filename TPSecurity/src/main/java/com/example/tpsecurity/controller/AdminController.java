package com.example.tpsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tpsecurity.auth.SecurityUtil;
import com.example.tpsecurity.entity.Role;
import com.example.tpsecurity.entity.Users;
import com.example.tpsecurity.repository.RoleRepository;
import com.example.tpsecurity.repository.UsersRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	SecurityUtil securityUtil;
	
	@Autowired
	UsersRepository uRepo;
	
	@Autowired
	RoleRepository rRepo;
	
	//    La route GET récupère tout les utilisateurs
    @GetMapping("/getuser")
	public List<Users> getAllUsers(@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token ){
    	
    	if (securityUtil.isValidToken(token) && securityUtil.canAcces(token, "ADMIN")) {
    		return uRepo.findAll();
    	}
    	return null;
    }
	
	//    La route POST permet d'ajouter des rôles à un utilisateur
    @PostMapping("/role/{id_user}/{id_role}")
    public boolean addRole(
    		@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token, 
    		@PathVariable("id_user") int idUser,
    		@PathVariable("id_role") int idRole) {
    	
    	if (securityUtil.isValidToken(token) && securityUtil.canAcces(token, "ADMIN")) {
    		Users u = uRepo.findById(idUser).orElse(null);
    		Role r = rRepo.findById(idRole).orElse(null);
    		r.getUsers().add(u);
    		rRepo.save(r);
    		return true;
    	}
    	return false;
    }
    
    //    La route DELETE supprime un utilisateur
    @DeleteMapping("/delete/{id}")
    public boolean deleteAccount(
    		@RequestHeader(name = HttpHeaders.AUTHORIZATION) String token, 
       		@PathVariable("id") int idUser) {
    	
    	if( securityUtil.isValidToken(token) && securityUtil.canAcces(token, "ADMIN")) {
    		Users u = uRepo.findById(idUser).orElse(null);
    		uRepo.delete(u);
    		return true;
    	}
    	return false;
    }
}
