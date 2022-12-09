package com.pace.soccerteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pace.soccerteam.beans.Lineup;
import com.pace.soccerteam.beans.Match;
import com.pace.soccerteam.repo.LineupRepository;
import com.pace.soccerteam.repo.MatchRepository;
import com.pace.soccerteam.security.payload.response.LineupResponse;
import com.pace.soccerteam.security.payload.response.MatchResponse;

@Component
public class MatchServiceImpl implements MatchService {
	
	@Autowired
	MatchRepository matchRepository;
	
	@Autowired
	LineupService lineupService;
	
	@Autowired
	LineupRepository lineupRepository;

	@Override
	public Match createMatch(Match match) {
		return matchRepository.save(match);
	}

	@Override
	public MatchResponse addLineup(Long matchId, Lineup lineup) {
		
		Match match = matchRepository.findById(matchId).get();
		if(lineupRepository.existsById(lineup.getId())) {
			match.setLineup(lineup);
		} 
		 matchRepository.save(match);
		 LineupResponse lineupResponse = new LineupResponse(lineup);
		
		return new MatchResponse(match.getId(), match.getDateTime(), match.getStatus(), match.getType(), match.getVenue(), 0, 0, lineupResponse);
	}

	@Override
	public LineupResponse getMatchLineup(Long id) {
		Match match = matchRepository.findById(id).get();
		Lineup lineup = match.getLineup();
		return new LineupResponse(lineup);
	}

}
