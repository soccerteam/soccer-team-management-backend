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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDateTime() {
		return dateTime;
	}

	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	public int getOppositionScore() {
		return oppositionScore;
	}

	public void setOppositionScore(int oppositionScore) {
		this.oppositionScore = oppositionScore;
	}

	public LineupResponse getLineupResponse() {
		return lineupResponse;
	}

	public void setLineupResponse(LineupResponse lineupResponse) {
		this.lineupResponse = lineupResponse;
	}
	
	
	
	


}
