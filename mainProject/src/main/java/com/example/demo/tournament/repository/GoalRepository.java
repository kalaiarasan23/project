package com.example.demo.tournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.tournament.entities.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long> {

}
