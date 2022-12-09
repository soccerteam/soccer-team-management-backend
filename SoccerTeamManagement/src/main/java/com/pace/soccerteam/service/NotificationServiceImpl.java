package com.pace.soccerteam.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.pace.soccerteam.beans.Notification;
import com.pace.soccerteam.beans.User;
import com.pace.soccerteam.repo.NotificationRepository;

@Component
public class NotificationServiceImpl implements NotificationService{
	
	@Autowired
	private NotificationRepository notificationRepository;


	private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

	public NotificationServiceImpl(){}

	@Override
	public Notification save(Notification notification){
		try{
			return notificationRepository.save(notification);
		}catch (Exception e) {
			logger.error("Exception occur while save Notification ",e);
			return null;
		}
	}


	@Override
	public Notification findByUser(User user){
		try{
			return notificationRepository.findByUser(user);
		}catch (Exception e) {
			logger.error("Exception occur while fetch Notification by User ",e);
			return null;
		}
	}

	@Override
	public List<Notification> findByUser(User user,Integer limit){
		try{
			return notificationRepository.userNotification(user.getId(), Pageable.ofSize(limit));
		}catch (Exception e) {
			logger.error("Exception occur while fetch Notification by User ",e);
			return null;
		}
	}


	@Override
	public Notification findByUserAndNotificationId(User user,Integer notificationId){
		try{
			return notificationRepository.findByUserAndId(user,notificationId);
		}catch (Exception e) {
			logger.error("Exception occur while fetch Notification by User and Notification Id ",e);
			return null;
		}
	}

}
