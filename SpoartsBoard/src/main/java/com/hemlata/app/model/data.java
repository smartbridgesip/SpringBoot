package com.hemlata.app.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class data{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String id;
	public Date dateM;
	public String Game;
	public Date getDateM() {
		return dateM;
	}
	public void setDateM(Date dateM) {
		this.dateM = dateM;
	}
	public String getGame() {
		return Game;
	}
	public void setGame(String game) {
		Game = game;
	}
	
}
