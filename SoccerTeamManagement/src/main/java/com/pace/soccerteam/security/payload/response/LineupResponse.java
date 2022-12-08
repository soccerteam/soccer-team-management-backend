package com.pace.soccerteam.security.payload.response;

import java.util.ArrayList;
import java.util.List;

import com.pace.soccerteam.beans.Lineup;
import com.pace.soccerteam.utils.UserJsonUtils;

public class LineupResponse {
	
	private long id;
	
	private List <UserInfoResponse> userInfoResponse = new ArrayList<>();
	
	

	public LineupResponse(Lineup lineup) {
		
		this.id = lineup.getId();
		this.userInfoResponse = UserJsonUtils.createUserLineupResponse(lineup);
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<UserInfoResponse> getUserInfoResponse() {
		return userInfoResponse;
	}

	public void setUserInfoResponse(List<UserInfoResponse> userInfoResponse) {
		this.userInfoResponse = userInfoResponse;
	}


}
