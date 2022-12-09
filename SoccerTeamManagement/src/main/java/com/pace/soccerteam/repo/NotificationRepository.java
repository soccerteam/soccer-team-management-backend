package com.pace.soccerteam.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pace.soccerteam.beans.Notification;
import com.pace.soccerteam.beans.User;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{
	
	Notification findByUser(User user);

	@Query("select n from Notification n where n.user.id=:userId ORDER BY n.createdAt DESC")
	List<Notification> userNotification(@Param("userId") long l,Pageable pageSize);

	Notification findByUserAndId(User user, Integer notificationId);

}
