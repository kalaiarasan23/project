package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Team {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> players = new ArrayList<>();
//    
    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

	public Team() {
		super();
	}
    
	public Team(String name) {
		super();
		this.name = name;
	}


	// Constructors, getters, setters
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

//	public int getPlayerCount() {
//        return players.size();
//    }
	
    public Tournament getTournament() {
		return tournament;
	}


	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
//
}