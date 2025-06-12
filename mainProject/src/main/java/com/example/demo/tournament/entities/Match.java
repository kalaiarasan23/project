package com.example.demo.tournament.entities;

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
//    
	@ManyToOne
	@JoinColumn(name = "team2_id")
	private Team team2;

	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL)
	private List<Goal> goals = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "tournament_id")
	private Tournament tournament;

//    public Match(LocalDate date, Team team1, Team team2) {
//		this.date = date;
//		this.team1 = team1;
//		this.team2 = team2;
//	}

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

//	public LocalDate getDate() {
//		return date;
//	}
//
//
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public List<Goal> getGoals() {
		goals.sort((o1,o2)->  Integer.compare(o1.getTime(), o2.getTime()) );
		return goals;
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

	public long getTeam1Score() {
		return goals.stream().filter(goal -> goal.getTeam().getId().equals(team1.getId())).count();
	}

	public long getTeam2Score() {
		return goals.stream().filter(goal -> goal.getTeam().getId().equals(team2.getId())).count();
	}

	@Override
	public String toString() {
		return "Match [id=" + id + "]";
	}

//
//	public String getScore() {
//        long team1Goals = goals.stream().filter(g -> g.getTeam().equals(team1)).count();
//        long team2Goals = goals.stream().filter(g -> g.getTeam().equals(team2)).count();
//        return team1.getName() + " " + team1Goals + " - " + team2Goals + " " + team2.getName();
//    }

}
