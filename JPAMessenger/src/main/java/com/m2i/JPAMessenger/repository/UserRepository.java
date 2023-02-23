package com.m2i.JPAMessenger.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.JPAMessenger.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{

	//1. Trouver un Users par son email
	Optional<Users> findByEmail(String email);
	
    //2. Trouver une liste de 'Users' par leurs firstName
	List<Users> findByFirstName(String firstName);
	
    //3. Trouver tout les utilisateur dont le firstName contient un la variable envoyé en parametre
	List<Users> findByFirstNameContaining(String firstName);
}
