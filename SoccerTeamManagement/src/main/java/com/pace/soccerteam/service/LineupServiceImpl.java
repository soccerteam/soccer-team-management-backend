package com.pace.soccerteam.service;

import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pace.soccerteam.beans.Lineup;
import com.pace.soccerteam.beans.User;
import com.pace.soccerteam.repo.LineupRepository;
import com.pace.soccerteam.repo.UserInfoRepository;

@Component
public class LineupServiceImpl implements LineupService{
	
	@Autowired
	private UserInfoRepository userRepository;
	
	@Autowired
	private LineupRepository lineupRepository; 
	
	@Transactional
	@Override
	public Set<User> getUsersFromRequest(Set<User> users) {
	return users.stream().map(user -> userRepository.findByUsername(user.getUsername()).get()).collect(Collectors.toSet());
	}

	@Override
	public Lineup saveLineup(Lineup lineup) {
		return lineupRepository.saveAndFlush(lineup);
	}
	
	@Override
	public Lineup getLineupById(long id) {
		return lineupRepository.findLineupById(id);
	}

}
