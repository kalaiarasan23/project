package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.repository.GoalRepository;
import com.example.demo.repository.MatchRepository;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.TeamRepository;
import com.example.demo.repository.TournamentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TournamentService {
    
    private final TournamentRepository tournamentRepository;
//    private final TeamRepository teamRepository;
//    private final MatchRepository matchRepository;
//    private final PlayerRepository playerRepository;
//    private final GoalRepository goalRepository;

    public TournamentService(
            TournamentRepository tournamentRepository,
            TeamRepository teamRepository,
            MatchRepository matchRepository,
            PlayerRepository playerRepository,
            GoalRepository goalRepository) {
        this.tournamentRepository = tournamentRepository;
//        this.teamRepository = teamRepository;
//        this.matchRepository = matchRepository;
//        this.playerRepository = playerRepository;
//        this.goalRepository = goalRepository;
    }
//
//    // Tournament Operations
//    public Tournament createTournament(String name, int maxTeams) {
//        Tournament tournament = new Tournament(name, maxTeams);
//        return tournamentRepository.save(tournament);
//    }
//
//    public Tournament getTournamentById(Long id) {
//        return tournamentRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Tournament not found with id: " + id));
//    }
//
//    // Team Operations
//    public Team addTeamToTournament(Long tournamentId, String teamName) {
//        Tournament tournament = getTournamentById(tournamentId);
//        
//        if (tournament.getTeams().size() >= tournament.getMaxTeams()) {
//            throw new IllegalStateException("Tournament has reached maximum team capacity");
//        }
//        
//        Team team = new Team(teamName);
//        team.setTournament(tournament);
//        return teamRepository.save(team);
//    }
//
//    // Player Operations
//    public Player addPlayerToTeam(Long teamId, String playerName) {
//        Team team = teamRepository.findById(teamId)
//                .orElseThrow(() -> new RuntimeException("Team not found"));
//        
//        Player player = new Player(playerName);
//        player.setTeam(team);
//        return playerRepository.save(player);
//    }
//
//    // Match Operations
//    public Match scheduleMatch(Long tournamentId, Long team1Id, Long team2Id, LocalDate date) {
//        Tournament tournament = getTournamentById(tournamentId);
//        Team team1 = teamRepository.findById(team1Id)
//                .orElseThrow(() -> new RuntimeException("Team 1 not found"));
//        Team team2 = teamRepository.findById(team2Id)
//                .orElseThrow(() -> new RuntimeException("Team 2 not found"));
//        
//        if (!tournament.getTeams().contains(team1) || !tournament.getTeams().contains(team2)) {
//            throw new IllegalArgumentException("Both teams must belong to the tournament");
//        }
//        
//        Match match = new Match(date, team1, team2);
//        match.setTournament(tournament);
//        return matchRepository.save(match);
//    }
//
//    // Goal Operations
//    public Goal recordGoal(Long matchId, Long playerId, Long teamId, LocalTime time) {
//        Match match = matchRepository.findById(matchId)
//                .orElseThrow(() -> new RuntimeException("Match not found"));
//        Player player = playerRepository.findById(playerId)
//                .orElseThrow(() -> new RuntimeException("Player not found"));
//        Team team = teamRepository.findById(teamId)
//                .orElseThrow(() -> new RuntimeException("Team not found"));
//        
//        if (!match.getTeam1().equals(team) && !match.getTeam2().equals(team)) {
//            throw new IllegalArgumentException("Team didn't participate in this match");
//        }
//        
//        Goal goal = new Goal(time, player, team);
////        goal.setMatch(match);;
//        return goalRepository.save(goal);
//    }
//
//	public List<Tournament> getAllTournaments() {
//		// TODO Auto-generated method stub
//		return tournamentRepository.findAll();
//	}
}