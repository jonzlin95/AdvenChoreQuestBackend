package com.cs160.groupj.advenchorequest.models;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Child {

	@Id
	private int id;
	private Family family;
	private List<Task> tasks;
	private int points;
	private int level;
	private int pointsToNextLevel;
	private String charType;
	private String charTypeFlavor;
	
	public Child() {
		// TODO Auto-generated constructor stub
	}

	/* Getter Functions */
	
	public int getId() {
		return id;
	}
	
	public Family getFamily() {
		return family;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}
	
	public int getPoints() {
		return points;
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getpointsToNextLevel() {
		return pointsToNextLevel;
	}
	
	public String getCharType() {
		return charType;
	}
	
	public String getCharTypeFlavor() {
		return charTypeFlavor;
	}
	
	/* Setter Functions */
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setFamily(Family family) {
		this.family = family;
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setPointsToNextLevel(int pointsToNextLevel) {
		this.pointsToNextLevel = pointsToNextLevel;
	}
	
	public void setCharType(String charType) {
		this.charType = charType;
	}
	
	public void setCharTypeFlavor(String charTypeFlavor) {
		this.charTypeFlavor = charTypeFlavor;
	}
}
