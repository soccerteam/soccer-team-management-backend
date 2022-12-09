package com.pace.soccerteam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pace.soccerteam.beans.Lineup;
import com.pace.soccerteam.beans.Match;
import com.pace.soccerteam.security.payload.response.LineupResponse;
import com.pace.soccerteam.security.payload.response.MatchResponse;

@Service
public interface MatchService {
	
	public Match createMatch(Match match);
	
	public MatchResponse addLineup(Long matchId, Lineup lineup);
	
	public LineupResponse getMatchLineup(Long id);

	List<MatchResponse> getAllMatches();

}
