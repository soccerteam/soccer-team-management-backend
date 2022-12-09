package com.pace.soccerteam.service;

import java.util.List;

import com.pace.soccerteam.security.payload.response.MatchStatisticsResponse;

public interface MatchStatisticsService {
	
	List <MatchStatisticsResponse> getMatchStatiscs();
	
	MatchStatisticsResponse getMatchStatisticsByMatchId(long matchId);

}
