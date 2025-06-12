package com.example.demo.tournament.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.tournament.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
	Optional<Team> findByName(String name);
}
