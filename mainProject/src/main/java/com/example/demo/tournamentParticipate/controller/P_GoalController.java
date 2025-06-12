package com.example.demo.tournamentParticipate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.tournamentParticipate.entities.P_Goal;
import com.example.demo.tournamentParticipate.entities.P_Match;
import com.example.demo.tournamentParticipate.entities.P_Player;
import com.example.demo.tournamentParticipate.repository.P_GoalRepository;
import com.example.demo.tournamentParticipate.repository.P_MatchRepository;
import com.example.demo.tournamentParticipate.repository.P_PlayerRepository;

@Controller
@RequestMapping("/tournaments/participate/{tournamentId}/team/{team_id}/matches/{matchId}")
public class P_GoalController {

    private final P_MatchRepository matchRepository;
    private final P_GoalRepository goalRepository;
    private final P_PlayerRepository playerRepository;

    
    public P_GoalController(P_MatchRepository matchRepository, P_GoalRepository goalRepository,
			P_PlayerRepository playerRepository) {
		this.matchRepository = matchRepository;
		this.goalRepository = goalRepository;
		this.playerRepository = playerRepository;
	}

	@GetMapping
    public String showGoalForm(@PathVariable Long tournamentId,
    						   @PathVariable Long team_id,
                               @PathVariable Long matchId,
                               Model model) {
//		Team team = tea
		
        P_Match match = matchRepository.findById(matchId).orElseThrow();
        model.addAttribute("match", match);
//        model.addAttribute("team", team);
        model.addAttribute("goal", new P_Goal());
        return "participate/goal"; // Create this HTML file
    }

    @PostMapping
    public String addGoal(@PathVariable Long tournamentId,
    					  @PathVariable Long team_id,	
                          @PathVariable Long matchId,
                          @ModelAttribute P_Goal goal) {
        P_Match match = matchRepository.findById(matchId).orElseThrow();
        goal.setMatch(match);
        goalRepository.save(goal);
        
        P_Player player = playerRepository.findById(goal.getPlayer().getId()).orElseThrow();
        goal.setPlayer(player);
        
        System.out.println(tournamentId+" "+matchId);
        return "redirect:/tournaments/participate/" + tournamentId +"/team/"+team_id +"/matches/" + matchId;
    }
    
    @PostMapping("/goal-update")
    public String updateGoals(@PathVariable Long tournamentId,
    						  @PathVariable Long team_id,
                              @PathVariable Long matchId,
                              @RequestParam int team1Goal,
                              @RequestParam int team2Goal) {
        P_Match match = matchRepository.findById(matchId).orElseThrow();
        
        match.setTeam1Goal(team1Goal);
        match.setTeam2Goal(team2Goal);
        matchRepository.save(match);

        return "redirect:/tournaments/participate/" + tournamentId +"/team/"+team_id +"/matches/" + matchId;
    }

 
}
