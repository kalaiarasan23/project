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
public class P_Player {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @ManyToOne
    @JoinColumn(name="team_player")
    private P_Team team;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
    private List<P_Goal> goals= new ArrayList<>();
    
    public P_Player() {
    	super();
    }
    
    public P_Player(String name) {
    	this.name = name;
    }

    public List<P_Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<P_Goal> goals) {
		this.goals = goals;
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

	public P_Team getTeam() {
		return team;
	}

	public void setTeam(P_Team team) {
		this.team = team;
	}
	
    // Constructors, getters, setters
}