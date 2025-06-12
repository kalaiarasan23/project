package com.example.demo.tournamentParticipate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.tournamentParticipate.entities.P_Team;
import com.example.demo.tournamentParticipate.entities.P_Tournament;
import com.example.demo.tournamentParticipate.repository.P_TeamRepository;
import com.example.demo.tournamentParticipate.repository.P_TournamentRepository;

@Controller
@RequestMapping("/tournaments/participate/{tournament_id}/team")
public class P_TeamController {
	
	@Autowired
	private P_TournamentRepository tournamentRepository;
	@Autowired
	private P_TeamRepository teamRepository;
	
	@GetMapping
	public String teamCreation(Model model, @PathVariable Long tournament_id) {
//		model.addAttribute("all teams",tournamentService.toString());
		P_Tournament tournament = tournamentRepository.findById(tournament_id).orElseThrow(() -> new RuntimeException("Tournament not found with id: " + tournament_id));
		P_Team team = new P_Team();
		team.setTournament(tournament); //team is create fk so we set tournament to team
		
		model.addAttribute("teams",tournament.getTeam());
		model.addAttribute("team",team);
		return "participate/team";
	}
	
	@PostMapping
	public String showCreation(@ModelAttribute P_Team team,@PathVariable Long tournament_id) {
		P_Tournament tournament = tournamentRepository.findById(tournament_id)
				.orElseThrow(() -> new RuntimeException("tournament is not found by "+tournament_id));
		team.setTournament(tournament); // this is too impartant to map bank to tournament. some time the getMapping set method not work. so we set the tournament here.
		teamRepository.save(team);
		return "redirect:/tournaments/participate/"+tournament_id+"/team";
	}
	
	
}
