package com.m2i.JPAMessenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.JPAMessenger.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer>{

}
