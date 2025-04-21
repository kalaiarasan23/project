package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Team;
import com.example.demo.entities.Tournament;
import com.example.demo.repository.TeamRepository;
import com.example.demo.repository.TournamentRepository;

@Controller
@RequestMapping("/tournaments/{tournament_id}/team")
public class TeamController {
	
	@Autowired
	private TournamentRepository tournamentRepository;
	@Autowired
	private TeamRepository teamRepository;
	
	@GetMapping
	public String teamCreation(Model model, @PathVariable Long tournament_id) {
//		model.addAttribute("all teams",tournamentService.toString());
		Tournament tournament = tournamentRepository.findById(tournament_id).orElseThrow(() -> new RuntimeException("Tournament not found with id: " + tournament_id));
		Team team = new Team();
		team.setTournament(tournament); //team is create fk so we set tournament to team
		model.addAttribute("teams",tournament.getTeams());
		model.addAttribute("team",team);
		return "team";
	}
	
	@PostMapping
	public String showCreation(@ModelAttribute Team team,@PathVariable Long tournament_id) {
		Tournament tournament = tournamentRepository.findById(tournament_id)
				.orElseThrow(() -> new RuntimeException("tournament is not found by "+tournament_id));
		team.setTournament(tournament); // this is too impartant to map bank to tournament. some time the getMapping set method not work. so we set the tournament here.
		teamRepository.save(team);
		return "redirect:/tournaments/"+tournament_id+"/team";
	}
	
	
}
