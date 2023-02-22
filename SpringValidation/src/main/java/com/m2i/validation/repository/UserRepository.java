package com.m2i.validation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.validation.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
