package com.m2i.queries.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.queries.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByEmail(String email);
	
	Optional<Users> findByEmailAndName(String email, String name);
	
	//Users subjectPredicat();
	
	List<Users> findByEmailIsNot(String email);

	List<Users> findByEmailContaining(String email);
	
	
	Page<Users> findAll(Pageable p);
	
	
	
}
