package com.pace.soccerteam.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pace.soccerteam.beans.ERole;
import com.pace.soccerteam.beans.Role;
import com.pace.soccerteam.beans.User;
import com.pace.soccerteam.repo.UserInfoRepository;
import com.pace.soccerteam.security.payload.response.PlayerResponse;
import com.pace.soccerteam.security.payload.response.UserInfoResponse;
import com.pace.soccerteam.security.payload.response.UserVerifyResponse;
import com.pace.soccerteam.service.LineupService;
import com.pace.soccerteam.service.MatchService;
import com.pace.soccerteam.service.PlayerService;
import com.pace.soccerteam.service.UserDetailsServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/player")
public class PlayerController {

	@Autowired
	private MatchService matchService;
	
	@Autowired
	private LineupService lineupService;
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private PlayerService playerServices;

	
	//@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	  @GetMapping("/search")
	  public PlayerResponse searchPlayers(@RequestParam String query) {
		  
		  
		  List<User> users = userInfoRepository.findUserByQueryConatining(query);
		  List<UserInfoResponse> userInfoResponse = new ArrayList<>();
		  
for (User userDetails : users) {
	
	  Set<Role> userRoles = userDetails.getRoles();
	  List<String> roles = new ArrayList<String>();
	  
	  for (Role role : userRoles) {
		ERole currentRole = role.getName();
		roles.add(String.valueOf(currentRole));
	}

	  
	  
	userInfoResponse.add(new UserInfoResponse(userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), userDetails.getFirstName(), userDetails.getLastName(), roles , userDetails.isVerified()));
}
				  
				  //		return new UserInfoResponse(userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), userDetails.getFirstName(), userDetails.getLastName(), roles , userDetails.isVerified());
					
		  return new PlayerResponse(userInfoResponse);
		  //userInfoRepository.findUserByQuery(query)
	  }

	
	
}
