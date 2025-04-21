package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {

}
