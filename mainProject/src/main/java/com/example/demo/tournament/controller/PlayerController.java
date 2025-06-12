package com.example.demo.tournament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.tournament.entities.Player;
import com.example.demo.tournament.entities.Team;
import com.example.demo.tournament.repository.PlayerRepository;
import com.example.demo.tournament.repository.TeamRepository;

@Controller
@RequestMapping("/tournaments/{tournament_id}/team/{team_id}")
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private TeamRepository teamRepository;
	
	@GetMapping
	public String getPlayer(Model model,@PathVariable("team_id") Long teamId,@PathVariable("tournament_id") Long tournamentId) {
		System.out.println("entered on player");
		Team team = teamRepository.findById(teamId)
				.orElseThrow(() -> new RuntimeException("team not found by id "+teamId));
		Player player = new Player();
		System.out.println("out on player");
//		player.setTeam(team);
		System.out.println("team setted");
		model.addAttribute("team_id",teamId);
		model.addAttribute("tournament_id",tournamentId);
		model.addAttribute("players",team.getPlayers());
		model.addAttribute("player", player);
		return "player";
	}
	
	@PostMapping
	public String savePlayer(@ModelAttribute Player player, @PathVariable("team_id") Long teamId,@PathVariable("tournament_id") Long tournamentId) {
		Team team = teamRepository.findById(teamId)
				.orElseThrow(()-> new RuntimeException("team not found "+teamId));
		player.setTeam(team);
		playerRepository.save(player);
		return "redirect:/tournaments/"+tournamentId+"/team/"+teamId;
	}
	
	@PostMapping("/delete/{player_id}")
	public String deletePlayer(@PathVariable Long tournament_id, 
	                           @PathVariable Long team_id, 
	                           @PathVariable Long player_id) {
	    playerRepository.deleteById(player_id);
	    return "redirect:/tournaments/" + tournament_id + "/team/" + team_id;
	}

	
	
}
