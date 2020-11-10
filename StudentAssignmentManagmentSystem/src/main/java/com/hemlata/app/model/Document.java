package com.hemlata.app.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Document {
	
	@javax.persistence.Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long Id;
	
	@Column(length=512,nullable=false,unique=false)
	private String NAme;
	private Long size;
	@Column(length=512000)
	private byte[] content;
	private Date uploadedDate;
	private Date DueDate;
private String status;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNAme() {
		return NAme;
	}
	public void setNAme(String nAme) {
		NAme = nAme;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	
	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
	public Date getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDueDate() {
		return DueDate;
	}
	public void setDueDate(Date dueDate) {
		DueDate = dueDate;
	}
	
}
