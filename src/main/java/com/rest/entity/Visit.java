package com.rest.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Visit extends BaseEntity{

	@DateTimeFormat
	private Date date;
	
	private String description;
	
	private Pet pet;
	
	public Visit (){
		this.date = new Date();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	
}
