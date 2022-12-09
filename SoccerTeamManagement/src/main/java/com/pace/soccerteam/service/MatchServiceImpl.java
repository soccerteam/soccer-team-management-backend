package com.pace.soccerteam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pace.soccerteam.beans.Lineup;
import com.pace.soccerteam.beans.Match;
import com.pace.soccerteam.repo.MatchRepository;

@Component
public class MatchServiceImpl implements MatchService {
	
	@Autowired
	MatchRepository matchRepository;

	@Override
	public Match createMatch(Match match) {
		
		return null;
	}

	@Override
	public Match addLineup(Lineup lineup) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Match getMatchLineup(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
