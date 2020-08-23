package com.example.demo.domain.models;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_TASKS")
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	private String title;
	
	private String description;
	
	private Boolean completed;
	
	public String getTitle() {
		return this.title;
	}
	
	public Integer getId() {
		return this.Id;
	}
	
	public void setTitle(String title) { 
		this.title = title;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getCompleted() {
		return this.completed;
	}
	
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	
}
