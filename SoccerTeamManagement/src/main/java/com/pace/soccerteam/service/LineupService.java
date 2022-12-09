package com.pace.soccerteam.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.pace.soccerteam.beans.Lineup;
import com.pace.soccerteam.beans.User;

@Service
public interface LineupService {
	
	public Set<User> getUsersFromRequest(Set<User> users);
	
	public Lineup saveLineup(Lineup lineup);
	
	public Lineup getLineupById(long id);
	
	List<Lineup> getAllLineups();

}
