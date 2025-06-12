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
public class P_Match {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "team1_id")
	private P_Team team1;

	private int team1Goal;   
	
	private String team2;
	
	private int team2Goal;

	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
	private List<P_Goal> goals = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "tournament_id")
	private P_Tournament tournament;

	public P_Match() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public P_Team getTeam1() {
		return team1;
	}

	public void setTeam1(P_Team team1) {
		this.team1 = team1;
	}

	public int getTeam1Goal() {
		return team1Goal;
	}

	public void setTeam1Goal(int team1Goal) {
		this.team1Goal = team1Goal;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public int getTeam2Goal() {
		return team2Goal;
	}

	public void setTeam2Goal(int team2Goal) {
		this.team2Goal = team2Goal;
	}

	public List<P_Goal> getGoals() {
		return goals;
	}

	public void setGoals(List<P_Goal> goals) {
		this.goals = goals;
	}

	public P_Tournament getTournament() {
		return tournament;
	}

	public void setTournament(P_Tournament tournament) {
		this.tournament = tournament;
	}

	// Constructors, getters, setters



	// sorting the goal as per time
//	public List<Goal> getGoals() {
//		goals.sort((o1,o2)->  Integer.compare(o1.getTime(), o2.getTime()) );
//		return goals;
//	}
	
	//
	
}
