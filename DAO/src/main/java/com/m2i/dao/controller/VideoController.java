package com.m2i.dao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.dao.entity.Author;
import com.m2i.dao.entity.Video;
import com.m2i.dao.model.VideoDetails;
import com.m2i.dao.service.VideoService;



@RestController
@RequestMapping("/video")
public class VideoController {

	@Autowired
	VideoService vService;
	
	@GetMapping("/fake")
	public Video fakeEleve() {
		Video v = new Video();
		vService.create(v);
		return v;
	}
	
	@GetMapping("/{id}")
	public Video getEleveById(@PathVariable("id") int id) {
		return vService.getById(id);
	}
	
	@GetMapping
	public List<Video> getAll(){
		return vService.getAll();
	}
	
	@PostMapping
	public void postEleve(@RequestBody Video v) {
		vService.create(v);
	}
	
	@PutMapping("/{id}")
	public void putEleve(@PathVariable("id") int id,@RequestBody Video v) {
		vService.update(id, v);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEleve(@PathVariable("id") int id) {
		vService.delete(id);
	}
	
	
	
	@GetMapping("/videodetails/{idvid}")
	public VideoDetails getVideoDetails(@PathVariable("idvid") int idVideo  ) {
		
		Video v = vService.getById(idVideo);
		Author a = v.getAuthor();
		
		VideoDetails vd = new VideoDetails(v, a);
		
		return vd;
	}
	
	
}
