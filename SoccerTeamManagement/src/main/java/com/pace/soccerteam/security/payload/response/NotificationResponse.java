package com.pace.soccerteam.security.payload.response;

import com.pace.soccerteam.beans.Notification;

public class NotificationResponse {

	private long id;
	
	private String message;
	
	private long createdAt;
	
	private boolean isRead;
	
	private UserInfoResponse userInfo;
	
	
	public NotificationResponse(Notification notification, UserInfoResponse userInfo) {
		this.id = notification.getId();
		this.message = notification.getMessage();
		this.createdAt = notification.getCreatedAt();
		this.isRead = notification.isRead();
		this.userInfo = userInfo;
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public long getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}


	public boolean isRead() {
		return isRead;
	}


	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}


	public UserInfoResponse getUserInfo() {
		return userInfo;
	}


	public void setUserInfo(UserInfoResponse userInfo) {
		this.userInfo = userInfo;
	}
	
	
	
}
