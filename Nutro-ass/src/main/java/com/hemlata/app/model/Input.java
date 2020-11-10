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
	public String ques;
	public int cal;
	public String Iname;
	public String weightUnit;
	public String Sunit;
	public float Samount;
	public String Dishname;
	

	public String getDishname() {
		return Dishname;
	}
	public void setDishname(String dishname) {
		Dishname = dishname;
	}
	public String getQues() {
		return ques;
	}
	public void setQues(String ques) {
		this.ques = ques;
	}
	public int getCal() {
		return cal;
	}

	public void setCal(int cal) {
		this.cal = cal;
	}
	public String getIname() {
		return Iname;
	}
	public void setIname(String iname) {
		Iname = iname;
	}
	public String getWeightUnit() {
		return weightUnit;
	}
	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}
	public String getSunit() {
		return Sunit;
	}
	public void setSunit(String sunit) {
		Sunit = sunit;
	}
	public float getSamount() {
		return Samount;
	}
	public void setSamount(float samount) {
		Samount = samount;
	}
	
	
}
