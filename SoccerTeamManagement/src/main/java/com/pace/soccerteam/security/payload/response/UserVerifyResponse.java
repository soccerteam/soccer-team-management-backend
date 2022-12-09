package com.pace.soccerteam.security.payload.response;



public class UserVerifyResponse {
	
	
private boolean codeVerified;



public UserVerifyResponse(boolean verified) {
	this.codeVerified = verified;
	
}

public boolean isCodeVerified() {
	return codeVerified;
}

public void setCodeVerified(boolean codeVerified) {
	this.codeVerified = codeVerified;
}



}
