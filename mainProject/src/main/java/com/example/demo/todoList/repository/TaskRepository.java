package com.example.demo.todoList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.todoList.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
