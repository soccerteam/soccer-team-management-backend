package com.pace.soccerteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pace.soccerteam.repo.UserInfoRepository;
import com.pace.soccerteam.security.payload.response.UserVerifyResponse;
import com.pace.soccerteam.service.LineupService;
import com.pace.soccerteam.service.MatchService;

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
	
	
	
	 
	  @PostMapping("/search")
	  public UserVerifyResponse verify(@RequestParam String query) {
		  



		  //username, @RequestBody String verificationCode
		  
		  
		
		  //String vc = verificationCode.trim();
		  return userInfoRepository.findByPlayerQuery(query);
	  }

	
	
}
