package com.pace.soccerteam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pace.soccerteam.beans.Notification;
import com.pace.soccerteam.beans.User;

@Service
public interface NotificationService {

	Notification save(Notification notification);

	Notification findByUser(User user);

	List<Notification> findByUser(User user, Integer limit);

	Notification findByUserAndNotificationId(User user, Integer notificationId);

}
