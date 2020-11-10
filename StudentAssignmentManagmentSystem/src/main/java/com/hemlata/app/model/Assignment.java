package com.hemlata.app.model;

import java.io.File;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.Nullable;
@Entity
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long AssID;
	String AssName;
	String SubjectName;
	Date DueDate;
	@Nullable
	int Marks;

	public Long getAssID() {
		return AssID;
	}
	public void setAssID(Long assID) {
		AssID = assID;
	}
	public String getAssName() {
		return AssName;
	}
	public void setAssName(String assName) {
		AssName = assName;
	}
	public String getSubjectName() {
		return SubjectName;
	}
	public void setSubjectName(String subjectName) {
		SubjectName = subjectName;
	}
	public Date getDueDate() {
		return DueDate;
	}
	public void setDueDate(Date dueDate) {
		DueDate = dueDate;
	}
	public int getMarks() {
		return Marks;
	}
	public void setMarks(int marks) {
		Marks = marks;
	}
	
	
}
