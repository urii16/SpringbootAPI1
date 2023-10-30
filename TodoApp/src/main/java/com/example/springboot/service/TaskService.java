package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.springboot.exceptions.ToDoExceptions;
import com.example.springboot.mapper.TaskInDTOToTask;
import com.example.springboot.persistence.entity.Task;
import com.example.springboot.persistence.entity.TaskStatus;
import com.example.springboot.persistence.repository.TaskRepository;
import com.example.springboot.service.dto.TaskInDTO;

@Service
public class TaskService {
	
	private final TaskRepository repository;
	private final TaskInDTOToTask mapper;
	
	public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public Task createTask(TaskInDTO taskInDTO) {
		Task task = mapper.map(taskInDTO);
		return this.repository.save(task);
	}
	
	public List<Task> findAll(){
		return this.repository.findAll();
	}
	
	public List<Task> findAllByTaskStatus(TaskStatus status){
		return this.repository.findAllByTaskStatus(status);
	}
	
	@Transactional
	public void updatetaskAsFinished(Long id) {
		Optional<Task> optionaltask = this.repository.findById(id);
		if(optionaltask.isEmpty()) {
			throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
		}
		this.repository.markTaskAsFinished(id);
	}
	
	public void deleteById(Long id) {
		Optional<Task> optionaltask = this.repository.findById(id);
		if(optionaltask.isEmpty()) {
			throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
		}
		this.repository.deleteById(id);
	}

}
