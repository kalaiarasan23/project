package com.example.demo.tournamentParticipate.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class P_Tournament {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
      
    @OneToMany(mappedBy = "tournament",cascade = CascadeType.ALL)
    private List<P_Team> team;
    
   
    public P_Tournament() {
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

	public List<P_Team> getTeam() {
		return team;
	}

	public void setTeam(List<P_Team> team) {
		this.team = team;
	}
	
	

}