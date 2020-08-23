package com.example.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.models.Task;

public interface TaskRepository  extends JpaRepository<Task, Integer> {
	Task findById(int id);
}
