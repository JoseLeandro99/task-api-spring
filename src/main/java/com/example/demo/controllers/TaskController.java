package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.models.Task;
import com.example.demo.domain.repository.TaskRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class TaskController {

	@Autowired
	TaskRepository taskRepository;
	
	@GetMapping("/tasks")
	public List<Task> getTasks() {
		return taskRepository.findAll();
	}
	
	@GetMapping("/tasks/{id}")
	public Task getTaskById(@PathVariable(value = "id") int id) {
		var task = taskRepository.findById(id);
		return task;
	}
	
	@PostMapping("/tasks")
	public String createTask(@RequestBody Task task) {
		taskRepository.save(task);
		
		return "Tarefa criada com sucesso!";
	}
	
	@PutMapping("/tasks/{id}")
	public String updateTask(@PathVariable(value = "id") int id, @RequestBody Task task) {
		var selectTask = taskRepository.findById(id);
		
		selectTask.setTitle(task.getTitle());
		selectTask.setDescription(task.getDescription());
		selectTask.setCompleted(task.getCompleted());
		
		taskRepository.save(selectTask);
		
		return String.format("Tarefa %s atualizada com sucesso!", selectTask.getTitle());
	}
	
	@DeleteMapping("/tasks/{id}")
	public String deleteTask(@PathVariable(value = "id") int id) {
		var selectedTask = taskRepository.findById(id);
		taskRepository.delete(selectedTask);
		
		return String.format("Tarefa %s excluída com succeso!", selectedTask.getTitle());
	}
	
}
