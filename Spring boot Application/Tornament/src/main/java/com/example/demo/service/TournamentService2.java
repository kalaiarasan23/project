package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Tournament;
import com.example.demo.repository.TournamentRepository;

@Service
public class TournamentService2 {
	@Autowired
	TournamentRepository tournamentRepository;

	public List<Tournament> getAllTournaments() {
		System.out.println("entered");
		return tournamentRepository.findAll();
	}
	
	
	
}
