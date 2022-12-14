package com.pace.soccerteam.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pace.soccerteam.beans.Lineup;
import com.pace.soccerteam.beans.User;
import com.pace.soccerteam.repo.UserInfoRepository;
import com.pace.soccerteam.security.payload.request.LineupRequest;
import com.pace.soccerteam.security.payload.response.AllLineupsResponse;
import com.pace.soccerteam.security.payload.response.LineupResponse;
import com.pace.soccerteam.security.payload.response.UserInfoResponse;
import com.pace.soccerteam.service.LineupService;
import com.pace.soccerteam.utils.UserJsonUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/lineup")
public class LineupController {
	
	@Autowired
	private LineupService lineupService	;
	
	@Autowired
	private UserInfoRepository userRepository;
	
	

	@PostMapping("/create")
	public LineupResponse createLineup(@RequestBody LineupRequest lineupRequest) {
		
		Lineup lineup = new Lineup();
		Set <User> lineupUsers = lineupService.getUsersFromRequest(lineupRequest.getUsers());
		lineup.setUsers(lineupUsers);
		lineupService.saveLineup(lineup);
		Set<User> linkLineup = lineup.getUsers();
		userRepository.saveAllAndFlush(getPlayersForLineup(linkLineup, lineup));
		
		return new LineupResponse(lineupService.getLineupById(lineup.getId()));
	}
	
	@GetMapping("/lineups")
	public List<LineupResponse> getAllLineup() {
		
		List<Lineup> lineupList = lineupService.getAllLineups();
		List<LineupResponse> lineupResponseList = new ArrayList<LineupResponse>();
		for (Lineup lineup : lineupList) {
			LineupResponse lineupResponse = new LineupResponse(lineup);
			lineupResponseList.add(lineupResponse);
		}
		
		return lineupResponseList;
	}
	
	
	private Set<User> getPlayersForLineup(Set<User> users, Lineup lineup) {
		Set<User> userList = new HashSet<>();
		for (User user : users) {
			User newUser = user;
			newUser.getLineup().add(lineup);
			userList.add(user);
		}
		return userList;
		
	}

}
