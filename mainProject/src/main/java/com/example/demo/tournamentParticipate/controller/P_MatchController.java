package com.example.demo.tournamentParticipate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.tournamentParticipate.entities.P_Match;
import com.example.demo.tournamentParticipate.entities.P_Team;
import com.example.demo.tournamentParticipate.entities.P_Tournament;
import com.example.demo.tournamentParticipate.repository.P_MatchRepository;
import com.example.demo.tournamentParticipate.repository.P_TeamRepository;
import com.example.demo.tournamentParticipate.repository.P_TournamentRepository;

@Controller
@RequestMapping("/tournaments/participate/{tournament_id}/team/{team_id}/matches")
public class P_MatchController {

	@Autowired
	private P_TournamentRepository tournamentRepository;
	@Autowired
	private P_MatchRepository matchRepository;
	
	@Autowired
	private P_TeamRepository teamRepository;

	@GetMapping
	public String showMatchForm(@PathVariable Long tournament_id,@PathVariable Long team_id ,Model model) {
		P_Tournament tournament = tournamentRepository.findById(tournament_id)
				.orElseThrow(() -> new RuntimeException("Tournament not found"));
		P_Team team = teamRepository.findById(team_id)
				.orElseThrow(() -> new RuntimeException("team not found by id "+team_id));
		
		model.addAttribute("tournament", tournament);
		model.addAttribute("team", team);
		return "participate/match";
	}

	@PostMapping
	public String createMatch(@PathVariable Long tournament_id, 
					@PathVariable Long team_id, 
					@RequestParam String teamB
//					 @RequestParam String teamBPlace,
					) {
		
		P_Tournament tournament = tournamentRepository.findById(tournament_id)
				.orElseThrow(() -> new RuntimeException("Tournament not found"));
		P_Team teamA = teamRepository.findById(team_id)
				.orElseThrow(() -> new RuntimeException("team A not found"));
		P_Match match = new P_Match();	
		match.setTeam1(teamA);
		match.setTeam2(teamB);
//		match.setTeam2Place(teamBPlace);
		match.setTeam1Goal(0);
		match.setTeam2Goal(0);
		match.setTournament(tournament);
		matchRepository.save(match);

		return "redirect:/tournaments/participate/" + tournament_id + "/team/"+team_id+"/matches";
	}

	@GetMapping("/add")
	public String showAddMatchForm(@PathVariable Long team_id, Model model) {
		P_Team team = teamRepository.findById(team_id)
				.orElseThrow(() -> new RuntimeException("Tournament not found"));

		model.addAttribute("team", team);
//		model.addAttribute("newmatch", new Match());
		return "participate/addmatch"; // returns addmatch.html
	}
	
	@PostMapping("/{matchId}/delete")
	public String deleteMatch(@PathVariable Long tournament_id,
						@PathVariable Long team_id,
						@PathVariable Long matchId) {
	    matchRepository.deleteById(matchId);
		return "redirect:/tournaments/participate/" + tournament_id + "/team/"+team_id+"/matches";

	}

}
