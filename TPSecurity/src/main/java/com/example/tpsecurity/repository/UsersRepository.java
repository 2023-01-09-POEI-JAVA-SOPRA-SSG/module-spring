package com.example.tpsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tpsecurity.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

}
