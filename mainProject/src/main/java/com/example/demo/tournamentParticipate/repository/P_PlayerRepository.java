package com.example.demo.tournamentParticipate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.tournamentParticipate.entities.P_Player;

public interface P_PlayerRepository extends JpaRepository<P_Player, Long> {

}
