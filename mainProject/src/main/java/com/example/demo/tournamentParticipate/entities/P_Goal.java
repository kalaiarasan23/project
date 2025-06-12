package com.example.demo.tournamentParticipate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class P_Goal {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int time;
    
    @ManyToOne
    @JoinColumn(name = "player_id")
    private P_Player player;
    
    
    @ManyToOne
    @JoinColumn(name = "match_id")
    private P_Match match;
    
    // Constructors, getters, setters

	public P_Goal() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public P_Player getPlayer() {
		return player;
	}

	public void setPlayer(P_Player player) {
		this.player = player;
	}

	public P_Match getMatch() {
		return match;
	}

	public void setMatch(P_Match match) {
		this.match = match;
	}
    
}