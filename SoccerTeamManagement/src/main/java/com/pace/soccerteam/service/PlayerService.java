package com.pace.soccerteam.service;


import java.util.Set;
import org.springframework.stereotype.Service;
import com.pace.soccerteam.beans.User;

@Service
public interface PlayerService {
	
	public Set<User> findPlayerByQuery(String playername);
	

}
