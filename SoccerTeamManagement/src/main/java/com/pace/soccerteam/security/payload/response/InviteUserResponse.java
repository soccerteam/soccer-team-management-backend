package com.pace.soccerteam.security.payload.response;

public class InviteUserResponse {

	private boolean inviteSent;
	private String email;
	private String errorMessage;
	

	
	public InviteUserResponse(boolean inviteSent, String email, String errorMessage) {
		super();
		this.inviteSent = inviteSent;
		this.email = email;
		this.errorMessage = errorMessage;
	}

	public boolean isInviteSent() {
		return inviteSent;
	}

	public void setInviteSent(boolean inviteSent) {
		this.inviteSent = inviteSent;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
}
