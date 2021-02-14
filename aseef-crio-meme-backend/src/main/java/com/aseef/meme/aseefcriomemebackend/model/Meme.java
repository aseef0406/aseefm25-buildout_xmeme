package com.aseef.meme.aseefcriomemebackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="meme",schema="public")
public class Meme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	public long id;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "caption")
	public String caption;
	
	@Column(name = "url")
	public String url;
	
	public Meme() {
		
	}
	
	public Meme(long id, String name, String caption, String url) {
		super();
		this.id = id;
		this.name = name;
		this.caption = caption;
		this.url = url;
	}





	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCaption() {
		return caption;
	}


	public void setCaption(String caption) {
		this.caption = caption;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
}
