package com.m2i.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.dao.entity.Video;


public interface VideoRepository extends JpaRepository<Video, Integer> {}
