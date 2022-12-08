package com.pace.soccerteam.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.pace.soccerteam.beans.Lineup;
import com.pace.soccerteam.beans.User;
import com.pace.soccerteam.security.payload.response.UserInfoResponse;

public class UserJsonUtils {

	
	public static List<UserInfoResponse> createUserLineupResponse(Lineup lineup) {
		Set <User> lineupUsers = lineup.getUsers();
		List<UserInfoResponse> userInfoList = new ArrayList<>();
		for (User user : lineupUsers) {
			UserInfoResponse userInfoJson = new UserInfoResponse(user.getId(), user.getUsername(), user.getEmail(),user.getFirstName(), user.getLastName(), null, user.isVerified());
			userInfoList.add(userInfoJson);
		}
		return userInfoList;
		
	}
}
