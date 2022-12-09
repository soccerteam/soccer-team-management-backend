package com.pace.soccerteam.service;

import org.springframework.stereotype.Service;

import com.pace.soccerteam.beans.Lineup;
import com.pace.soccerteam.beans.Match;

@Service
public interface MatchService {
	
	public Match createMatch(Match match);
	
	public Match addLineup(Lineup lineup);
	
	public Match getMatchLineup(Long id);

}
