package com.pace.soccerteam.security.payload.response;

import java.util.ArrayList;

import java.util.List;
import java.util.List;

import com.pace.soccerteam.beans.Lineup;
import com.pace.soccerteam.utils.UserJsonUtils;

public class AllLineupsResponse {
	

	
	public AllLineupsResponse(List<Lineup> userInfoResponse) {
		super();
		this.userInfoResponse = userInfoResponse;
	}

	private List <Lineup> userInfoResponse = new ArrayList<>();

	public List<Lineup> getUserInfoResponse() {
		return userInfoResponse;
	}

	public void ListUserInfoResponse(List<Lineup> userInfoResponse) {
		this.userInfoResponse = userInfoResponse;
	}
	
	



}
