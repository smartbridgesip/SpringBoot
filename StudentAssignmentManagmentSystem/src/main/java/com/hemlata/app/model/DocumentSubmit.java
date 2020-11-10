package com.hemlata.app.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class DocumentSubmit {
	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long dsId; 
	private long Id;
	private long AssId;
	private Date uploadedDate;
	@Column(length=512,nullable=false,unique=false)
	private String NAme;
	private Long size;
	@Column(length=512000)
	private byte[] content;
	
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
	public long getAssId() {
		return AssId;
	}
	public void setAssId(long assId) {
		AssId = assId;
	}
	public Date getUploadedDate() {
		return uploadedDate;
	}
	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}
	
}
