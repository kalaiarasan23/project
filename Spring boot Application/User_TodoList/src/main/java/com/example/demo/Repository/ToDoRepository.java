package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entityClasses.TodoList;
import com.example.demo.entityClasses.Users;

public interface ToDoRepository extends JpaRepository<TodoList, Integer> {
    List<TodoList> findByUsers(Users user);
    
    void deleteByName(String name);
}
