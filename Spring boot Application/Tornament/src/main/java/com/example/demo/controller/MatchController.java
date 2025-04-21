package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Match;
import com.example.demo.entities.Team;
import com.example.demo.entities.Tournament;
import com.example.demo.repository.MatchRepository;
import com.example.demo.repository.TeamRepository;
import com.example.demo.repository.TournamentRepository;

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
		return "match";
	}

	@PostMapping
	public String createMatch(@PathVariable Long tournament_id, 
					@RequestParam Long teamA,
					@RequestParam Long teamB,
					@ModelAttribute Match match) {

		Tournament tournament = tournamentRepository.findById(tournament_id)
				.orElseThrow(() -> new RuntimeException("Tournament not found"));
		Team a = teamRepository.findById(teamA)
				.orElseThrow(() -> new RuntimeException("team A not found"));
		Team b = teamRepository.findById(teamB).
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
