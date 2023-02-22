package com.m2i.dao.model;

import java.util.Date;

import com.m2i.dao.entity.Author;
import com.m2i.dao.entity.Video;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VideoDetails {

	private String pseudo;
	private String url;
	private int duree;
	private int nbVue;
	private String title;
	private String description;
	private Date datePublication;
	
	public VideoDetails(Video v, Author a) {
		// From author :
		this.pseudo = a.getPseudo();
		
		//From video :
		this.url = v.getUrl();
		this.nbVue = v.getNbVue();
		this.duree = v.getDuree();
		this.title = v.getTitle();
		this.description = v.getDescription();
		this.datePublication = v.getDatePublication();
		
	}
	
	
	
	
}
