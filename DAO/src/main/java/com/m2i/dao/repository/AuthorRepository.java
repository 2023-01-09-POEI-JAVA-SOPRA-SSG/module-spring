package com.m2i.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.dao.entity.Author;


public interface AuthorRepository extends JpaRepository<Author, Integer>{}
