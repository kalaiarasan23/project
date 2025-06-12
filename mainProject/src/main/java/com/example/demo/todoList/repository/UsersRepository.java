package com.example.demo.todoList.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.todoList.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	Optional<Users> findByUserName(String name);
}
