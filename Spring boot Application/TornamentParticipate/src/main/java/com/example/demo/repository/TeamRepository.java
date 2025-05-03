package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
