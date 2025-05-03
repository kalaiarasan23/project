package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long> {

}
