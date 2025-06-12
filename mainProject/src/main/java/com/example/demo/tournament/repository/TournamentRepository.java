package com.example.demo.tournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.tournament.entities.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}
