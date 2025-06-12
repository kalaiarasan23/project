package com.example.demo.todoList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.todoList.entities.TodoList;
import com.example.demo.todoList.entities.Users;

public interface ToDoRepository extends JpaRepository<TodoList, Integer> {
    List<TodoList> findByUsers(Users user);
    
    void deleteByName(String name);
}
