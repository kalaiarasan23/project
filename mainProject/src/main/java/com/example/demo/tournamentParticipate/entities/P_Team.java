package com.example.demo.tournamentParticipate.entities;

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
public class P_Team {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<P_Player> players = new ArrayList<>();
//    
    @OneToMany(mappedBy = "team1", cascade = CascadeType.ALL)
    private List<P_Match> matches = new ArrayList<P_Match>();
    


	@ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id")
    private P_Tournament tournament;

    // Constructors, getters, setters
	public P_Team() {
		super();
	}
    
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
	
	public List<P_Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<P_Player> players) {
		this.players = players;
	}

//	public int getPlayerCount() {
//        return players.size();
//    }
	
	public List<P_Match> getMatches() {
		return matches;
	}
	
	public void setMatches(List<P_Match> matches) {
		this.matches = matches;
	}

	public P_Tournament getTournament() {
		return tournament;
	}


	public void setTournament(P_Tournament tournament) {
		this.tournament = tournament;
	}
//
}