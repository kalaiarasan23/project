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
public class Match {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "team1_id")
	private Team team1;
	private int Team1Goal;   
	
	private String team2;
	
	private int Team2Goal;

	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
	private List<Goal> goals = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "tournament_id")
	private Tournament tournament;

	public Match() {
		super();
	}

	// Constructors, getters, setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public void setGoals(List<Goal> goals) {
		this.goals = goals;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public int getTeam2Goal() {
		return Team2Goal;
	}

	public void setTeam2Goal(int team2Goal) {
		Team2Goal = team2Goal;
	}
	
	public int getTeam1Goal() {
		return Team1Goal;
	}

	public void setTeam1Goal(int team1Goal) {
		Team1Goal = team1Goal;
	}

	// sorting the goal as per time
	public List<Goal> getGoals() {
		goals.sort((o1,o2)->  Integer.compare(o1.getTime(), o2.getTime()) );
		return goals;
	}
	
	//
	
}
