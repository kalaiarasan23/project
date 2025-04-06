package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.TodoList;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {

}
