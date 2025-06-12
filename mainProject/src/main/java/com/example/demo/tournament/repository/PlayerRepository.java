package com.example.demo.tournament.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.tournament.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
