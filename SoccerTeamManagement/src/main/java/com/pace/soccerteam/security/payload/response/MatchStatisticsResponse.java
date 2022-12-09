package com.pace.soccerteam.security.payload.response;

import java.util.ArrayList;
import java.util.List;

import com.pace.soccerteam.beans.Match;
import com.pace.soccerteam.beans.MatchStatistics;

public class MatchStatisticsResponse {
	
	private long id;
	
	private Match match;
	
	private List<String> fouls = new ArrayList<>();
	
	private String score;
	
	public MatchStatisticsResponse(MatchStatistics matchStat) {
		this.id = matchStat.getId();
		this.match = matchStat.getMatch();
		this.fouls = matchStat.getFouls();
		this.score = matchStat.getScore();
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public List<String> getFouls() {
		return fouls;
	}

	public void setFouls(List<String> fouls) {
		this.fouls = fouls;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	

}
