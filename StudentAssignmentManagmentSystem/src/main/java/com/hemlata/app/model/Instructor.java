package com.hemlata.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long InstId;
	
	String emailId;;
	String Fname;
	String Lname;
	String Pass;
	String Subject;
	
	public Long getInstId() {
		return InstId;
	}
	
	public String getEmailId() {
		return emailId;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setInstId(Long instId) {
		InstId = instId;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	
	
}
