package com.cs160.groupj.advenchorequest.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Task {

	@Id
	private int id;
	private String name;
	private Child child;
	private Date startDate;
	private Date dueDate;
	private int pointValue;
	
	private boolean photo;
	private String photoURI;
	
	private int status;
	private String response;
	
	public Task() {
		// TODO Auto-generated constructor stub
	}
	
	/* Getter Functions */
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public Child getChild() {
		return child;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public int getPointValue() {
		return pointValue;
	}
	
	public boolean getPhoto() {
		return photo;
	}
	
	public String getPhotoURI() {
		return photoURI;
	}
	
	public int getStatus() {
		return status;
	}
	
	public String getResponse() {
		return response;
	}
	
	/* Setter Functions */
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setChild(Child child) {
		this.child = child;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public void setPointValue(int pointValue) {
		this.pointValue = pointValue;
	}
	
	public void setPhoto(boolean photo) {
		this.photo = photo;
	}
	
	public void setPhotoURI(String photoURI) {
		this.photoURI = photoURI;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setResponse(String response) {
		this.response = response;
	}
}
