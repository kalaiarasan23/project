package com.example.demo.tournamentParticipate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.tournamentParticipate.entities.P_Tournament;

public interface P_TournamentRepository extends JpaRepository<P_Tournament, Long> {

}
