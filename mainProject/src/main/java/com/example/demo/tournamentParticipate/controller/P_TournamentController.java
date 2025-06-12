package com.example.demo.tournamentParticipate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.tournamentParticipate.entities.P_Tournament;
import com.example.demo.tournamentParticipate.repository.P_TournamentRepository;

@Controller
@RequestMapping("/tournaments/participate")
public class P_TournamentController {
    
	@Autowired
    private P_TournamentRepository tournamentRepository;
 
//     Tournament Views
    @GetMapping
    public String listTournaments(Model model) {
//        model.addAttribute("tournaments", tournamentService.getAllTournaments());
        model.addAttribute("tournaments", tournamentRepository.findAll());
    	model.addAttribute("newTournament",new P_Tournament());
        return "participate/index";
    }

    @PostMapping
    public String showCreateForm(@ModelAttribute P_Tournament tournament,Model model) {
    	tournamentRepository.save(tournament);
    	model.addAttribute("tournament",tournament);
        return "redirect:/tournaments/participate/"+tournament.getId()+"/team";
    }
    
    @GetMapping("/{id}")
    public String viewTournament(@PathVariable Long id, Model model) {
        P_Tournament tournament = tournamentRepository.findById(id)
        		.orElseThrow(()-> new RuntimeException("tournament not found"));
        model.addAttribute("tournament", tournament);
        return "redirect:/tournaments/participate/"+tournament.getId()+"/team";
    }
    
    @PostMapping("/{id}/delete")
    public String viewTournament(@PathVariable Long id) {
       
        tournamentRepository.deleteById(id);
        return "redirect:/tournaments/participate";
    }

}