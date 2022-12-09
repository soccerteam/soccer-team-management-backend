package com.pace.soccerteam.security.payload.response;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pace.soccerteam.beans.Lineup;

public class MatchResponse {
	
	private long id;
	private long dateTime;
	private String status;
	private String type;
	private String venue;
	private int homeScore;
	private int oppositionScore;
	private LineupResponse lineupResponse;
	
	public MatchResponse(long id, long dateTime, String status, String type, String venue, int homeScore,
			int oppositionScore, LineupResponse lineupResponse) {
		super();
		this.id = id;
		this.dateTime = dateTime;
		this.status = status;
		this.type = type;
		this.venue = venue;
		this.homeScore = homeScore;
		this.oppositionScore = oppositionScore;
		this.lineupResponse = lineupResponse;
	}
	
	
	


}
