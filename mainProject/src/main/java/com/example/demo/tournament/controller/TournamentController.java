package com.example.demo.tournament.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import com.example.demo.tournament.entities.Tournament;
import com.example.demo.tournament.repository.TournamentRepository;

@Controller
@RequestMapping("/tournaments")
public class TournamentController {
    
	@Autowired
    private TournamentRepository tournamentRepository;

 
//     Tournament Views
    @GetMapping
    public String listTournaments(Model model) {
//        model.addAttribute("tournaments", tournamentService.getAllTournaments());
        model.addAttribute("tournaments", tournamentRepository.findAll());
    	model.addAttribute("newTournament",new Tournament());
        return "index";
    }

    @PostMapping
    public String showCreateForm(@ModelAttribute Tournament tournament,Model model) {
    	tournamentRepository.save(tournament);
    	model.addAttribute("tournament",tournament);
        return "TournamentDashBoard";
    }
    
    @GetMapping("{id}/scorers")
    public String showGoalLeaderboard(Model model,@PathVariable Long id) {
    	Tournament tournament = tournamentRepository.findById(id).orElseThrow(() -> new RuntimeException("no tournament is found"));
    	List<Team> teams = tournament.getTeams();

    	List<Player> players = new ArrayList<>();
    	
    	for(Team m : teams) {
    		players.addAll(m.getPlayers());
    	}
    	players = players.stream()
    	        .filter(p -> p.getGoals() != null && !p.getGoals().isEmpty())
    	        .collect(Collectors.toList());
        // Sort by goal count descending
        players.sort((p1, p2) -> Integer.compare(p2.getGoals().size(), p1.getGoals().size()));
        System.out.println(players);
        model.addAttribute("tournament",tournament);
        model.addAttribute("players", players);
        return "Topscorer";
    }
    

    @GetMapping("/{id}")
    public String viewTournament(@PathVariable Long id, Model model) {
        Tournament tournament = tournamentRepository.findById(id)
        		.orElseThrow(()-> new RuntimeException("tournament not found"));
        model.addAttribute("tournament", tournament);
        return "TournamentDashBoard";
    }
    
    @PostMapping("/{id}/delete")
    public String viewTournament(@PathVariable Long id) {
       
        tournamentRepository.deleteById(id);
        return "redirect:/tournaments";
    }

}