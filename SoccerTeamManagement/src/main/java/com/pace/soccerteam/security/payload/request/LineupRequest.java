package com.pace.soccerteam.security.payload.request;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.pace.soccerteam.beans.User;

public class LineupRequest {
	
	@NotBlank
	private Set<User> users = new HashSet<>();

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}
