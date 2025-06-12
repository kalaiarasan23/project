package com.example.demo.tournamentParticipate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.tournamentParticipate.entities.P_Player;
import com.example.demo.tournamentParticipate.entities.P_Team;
import com.example.demo.tournamentParticipate.repository.P_PlayerRepository;
import com.example.demo.tournamentParticipate.repository.P_TeamRepository;

@Controller
@RequestMapping("/tournaments/participate/{tournament_id}/team/{team_id}/add_players")
public class P_PlayerController {
	
	@Autowired
	private P_PlayerRepository playerRepository;
	@Autowired
	private P_TeamRepository teamRepository;
	
	@GetMapping
	public String getPlayer(Model model,@PathVariable("team_id") Long teamId,@PathVariable("tournament_id") Long tournamentId) {
		System.out.println("entered on player");
		P_Team team = teamRepository.findById(teamId)
				.orElseThrow(() -> new RuntimeException("team not found by id "+teamId));
		P_Player player = new P_Player();
		System.out.println("out on player");
//		player.setTeam(team);
		System.out.println("team setted");
		model.addAttribute("team_id",teamId);
		model.addAttribute("tournament_id",tournamentId);
		model.addAttribute("players",team.getPlayers());
		model.addAttribute("player", player);
		return "participate/player";
	}
	
	@PostMapping
	public String savePlayer(@ModelAttribute P_Player player, @PathVariable("team_id") Long teamId,@PathVariable("tournament_id") Long tournamentId) {
		P_Team team = teamRepository.findById(teamId)
				.orElseThrow(()-> new RuntimeException("team not found "+teamId));
		player.setTeam(team);
		playerRepository.save(player);
		return "redirect:/tournaments/participate/"+tournamentId+"/team/"+teamId+"/add_players";
	}
	
	@PostMapping("/delete/{player_id}")
	public String deletePlayer(@PathVariable Long tournament_id, 
	                           @PathVariable Long team_id, 
	                           @PathVariable Long player_id) {
	    playerRepository.deleteById(player_id);
	    return "redirect:/tournaments/participate/" + tournament_id + "/team/" + team_id+"/add_players";
	}
	
	@GetMapping("/scores")
	public String playersGoal(Model model, @PathVariable Long team_id) {
		P_Team team = teamRepository.findById(team_id)
				.orElseThrow(() -> new RuntimeException("team not found by id "+team_id));
		List<P_Player> p = team.getPlayers();
		model.addAttribute("players",p);
		model.addAttribute("team",team);
		return "participate/Topscorer";
	}
	
	
}
