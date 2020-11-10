package com.hemlata.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="cat_id")
	int catid;
	
	private String category;
	
	public String  getCategory() {
		return category;
	}

	public void setCategory(String  category) {
		this.category = category;
	}


	
}
