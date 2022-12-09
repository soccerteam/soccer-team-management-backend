package com.pace.soccerteam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pace.soccerteam.beans.Notification;
import com.pace.soccerteam.beans.User;
import com.pace.soccerteam.repo.UserInfoRepository;
import com.pace.soccerteam.security.payload.response.NotificationResponse;
import com.pace.soccerteam.security.payload.response.UserInfoResponse;
import com.pace.soccerteam.service.NotificationService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/notification")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private UserInfoRepository userRepository;
	
	@PostMapping("/notify")
	public NotificationResponse createNotification(@RequestBody Notification notification) {
		Notification saveNotification = notificationService.save(notification);
		User user = userRepository.findById(notification.getUser().getId()).get();
		UserInfoResponse userInfoResponse = new UserInfoResponse(user.getId(), user.getUsername(), user.getEmail(), user.getFirstName(), user.getLastName(), null, user.isVerified());
		NotificationResponse notificationResponse = new NotificationResponse(saveNotification, userInfoResponse);
		
		return notificationResponse;
		
	}
	
	@GetMapping("/user/{userId}/{limit}")
	public List<NotificationResponse> findNotificationsByUserId(@PathVariable long userId, @PathVariable int limit) {
		User user = userRepository.findById(userId).get();
		UserInfoResponse userInfoResponse = new UserInfoResponse(user.getId(), user.getUsername(), user.getEmail(), user.getFirstName(), user.getLastName(), null, user.isVerified());
		List<Notification> notificationList =  notificationService.findByUser(user, limit);
		List<NotificationResponse> responseList = new ArrayList<>();
		for (Notification notification : notificationList) {
			NotificationResponse notificationResponse = new NotificationResponse(notification, userInfoResponse);
			responseList.add(notificationResponse);
		}
		return responseList;
		
	}

}
