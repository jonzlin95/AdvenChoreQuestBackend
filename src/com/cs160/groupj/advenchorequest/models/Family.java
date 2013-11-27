package com.cs160.groupj.advenchorequest.models;

import javax.persistence.Entity;
import javax.persistence.Id;


import java.util.List;

@Entity
public class Family {

	@Id
	private String id;
	private List<Child> children;
	private List<Task> tasks;
	
	public Family() {
		// TODO Auto-generated constructor stub
	}
	
	/* Getter Functions */
	
	public String getId() {
		return id;
	}
	
	public List<Child> getChildren() {
		return children;
	}
	
	
	public List<Task> getTasks() {
		return tasks;
	}
	
	/* Setter Functions */
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setChildren(List<Child> children) {
		this.children = children;
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
}
