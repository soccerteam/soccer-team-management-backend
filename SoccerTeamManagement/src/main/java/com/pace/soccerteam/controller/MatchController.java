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

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/match")
public class MatchController {
	
	@Autowired
	private MatchRepository matchRepository;

	@GetMapping("/getmatches")
	public List<Match> getAllMatches() {
		return null;
	}
	
	@GetMapping("/{matchId}")
	public Match getSingleMatch(@PathVariable String matchId) {
		return null;
	}
	
	@PostMapping("/create")
	public Match createMatch(@RequestBody Match match) {
		
		matchRepository.save(match);
		return matchRepository.findById(match.getId()).get();
	}
}
