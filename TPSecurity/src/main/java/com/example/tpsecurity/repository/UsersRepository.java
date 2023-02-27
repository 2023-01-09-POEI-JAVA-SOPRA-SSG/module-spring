package com.example.tpsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tpsecurity.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	public Optional<Users> findByEmailAndPassword(String email, String password);
}
