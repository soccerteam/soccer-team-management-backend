package com.pace.soccerteam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pace.soccerteam.beans.Match;
import com.pace.soccerteam.repo.MatchRepository;
import com.pace.soccerteam.security.payload.response.LineupResponse;
import com.pace.soccerteam.security.payload.response.MatchResponse;
import com.pace.soccerteam.service.MatchService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/match")
public class MatchController {
	
	@Autowired
	private MatchRepository matchRepository;
	
	@Autowired
	private MatchService matchService;

	@GetMapping("/matches")
	public List<MatchResponse> getAllMatches() {
		return matchService.getAllMatches();
	}
	
	@GetMapping("/{matchId}")
	public LineupResponse getSingleMatch(@PathVariable String matchId) {
		
		return matchService.getMatchLineup(Long.parseLong(matchId));
	}
	
	@PostMapping("/create")
	public Match createMatch(@RequestBody Match match) {
		
		
		return matchService.createMatch(match);
	}
}
