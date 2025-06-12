package com.example.demo.tournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.tournament.entities.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {

}
