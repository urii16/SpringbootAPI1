package com.example.springboot.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "task")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String description;
	private LocalDateTime createdDate;
	private LocalDateTime eta;
	private boolean finished;
	private TaskStatus taskStatus;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	
	public LocalDateTime getEta() {
		return eta;
	}
	public void setEta(LocalDateTime eta) {
		this.eta = eta;
	}
	
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	public TaskStatus getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}
	
}
