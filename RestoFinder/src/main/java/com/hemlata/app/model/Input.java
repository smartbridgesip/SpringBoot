package com.hemlata.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Input {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String id;
	public int zip;
	public String state;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	
}
