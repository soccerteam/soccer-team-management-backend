package com.pace.soccerteam.security.payload.response;

import java.util.ArrayList;
import java.util.List;

import com.pace.soccerteam.beans.User;

public class PlayerResponse {
	
	private List <UserInfoResponse> players = new ArrayList<>();
	
	
	public PlayerResponse(List<UserInfoResponse> players) {
		super();
		this.players = players;
	}

	public List<UserInfoResponse> getPlayers() {
		return players;
	}

	public void setPlayers(List<UserInfoResponse> players) {
		this.players = players;
	}
	
	
	

}
