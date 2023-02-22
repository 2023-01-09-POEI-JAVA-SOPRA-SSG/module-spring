package com.m2i.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.dao.entity.Video;
import com.m2i.dao.repository.VideoRepository;



@Service
public class VideoService {

	@Autowired
	VideoRepository repo;
	
	public void create(Video v) {
		repo.save(v);
	}

	public Video getById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<Video> getAll() {
		return repo.findAll();
	}

	public void update(int id, Video v) {
		Video video = repo.findById(id).orElse(null);
		if (v!= null) {
			video.setAuthor(v.getAuthor());
			video.setDatePublication( v.getDatePublication());
			video.setDescription( v.getDescription());
			video.setDuree( v.getDuree());
			video.setNbVue( v.getNbVue());
			video.setTitle( v.getTitle());
			video.setUrl( v.getUrl());
						
			repo.save(video);
		}
	}

	public void delete(int id) {
		Video Video = repo.findById(id).orElse(null);
		if (Video!= null) {
			repo.delete(Video);
		}
		
	}

}
