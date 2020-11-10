package com.hemlata.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="balance")
public class Balance {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="bal_id")
	private int balId;
	private int bal;
	private long ballog;
	public int getBalId() {
		return balId;
	}

	public void setBalId(int balId) {
		this.balId = balId;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	public long getBallog() {
		return ballog;
	}

	public void setBallog(long ballog) {
		this.ballog = ballog;
	}


	
}
