package com.pace.soccerteam.security.payload.response;

import java.util.List;

public class UserInfoWithTokenResponse {


	private Long id;
	private String username;
	private String email;
	private String firstName;
	private String lastName;
	private boolean verified;
	private String token;
	private List<String> roles;

	public UserInfoWithTokenResponse(
			String token,
			Long id,
			String username, 
			String email,
			String firstName, 
			String lastName, 
			List<String> roles, 
			Boolean verified) {
		
		this.token = token;
		this.id = id;
		this.username = username;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = roles;
		this.verified = verified;
	}

	public Long getId() {
		return id;
	}
	
	
	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	
	
}
