package com.example.demo.tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.tournament.entities.Match;
import com.example.demo.tournament.entities.Team;
import com.example.demo.tournament.entities.Tournament;
import com.example.demo.tournament.repository.MatchRepository;
import com.example.demo.tournament.repository.TeamRepository;
import com.example.demo.tournament.repository.TournamentRepository;

@Controller
@RequestMapping("/tournaments/{tournament_id}/matches")
public class MatchController {

	@Autowired
	private TournamentRepository tournamentRepository;
	@Autowired
	private MatchRepository matchRepository;
	
	@Autowired
	private TeamRepository teamRepository;

	@GetMapping
	public String showMatchForm(@PathVariable Long tournament_id, Model model) {
		Tournament tournament = tournamentRepository.findById(tournament_id)
				.orElseThrow(() -> new RuntimeException("Tournament not found"));
		model.addAttribute("tournament", tournament);
		model.addAttribute("teamSize", tournament.getTeams().size());
		return "match";
	}

	@PostMapping
	public String createMatch(@PathVariable Long tournament_id, 
					@RequestParam String teamA,
					@RequestParam String teamB,
					@ModelAttribute Match match) {

		Tournament tournament = tournamentRepository.findById(tournament_id)
				.orElseThrow(() -> new RuntimeException("Tournament not found"));
		Team a = teamRepository.findByName(teamA)
				.orElseThrow(() -> new RuntimeException("team A not found"));
		Team b = teamRepository.findByName(teamB).
				orElseThrow(() -> new RuntimeException("team B not found"));
		match.setTeam1(a);
		match.setTeam2(b);
		match.setTournament(tournament);
		matchRepository.save(match);

		return "redirect:/tournaments/" + tournament_id + "/matches";
	}

	@GetMapping("/add")
	public String showAddMatchForm(@PathVariable Long tournament_id, Model model) {
		Tournament tournament = tournamentRepository.findById(tournament_id)
				.orElseThrow(() -> new RuntimeException("Tournament not found"));

		model.addAttribute("tournament", tournament);
		model.addAttribute("newmatch", new Match());
		return "addmatch"; // returns addmatch.html
	}
	
	@PostMapping("/{matchId}/delete")
	public String deleteMatch(@PathVariable Long tournament_id, @PathVariable Long matchId) {
	    matchRepository.deleteById(matchId);
	    return "redirect:/tournaments/" + tournament_id;
	}


//	public long getTeam2Score() {
//	    return goals.stream()
//	                .filter(goal -> goal.getTeam().getId().equals(team2.getId()))
//	                .count();
//	}

//	@GetMapping({ "{match_id}" })
//	public String matchById(Model model, @PathVariable("match_id") Long id) {
//
//		return "";
//	}
}
