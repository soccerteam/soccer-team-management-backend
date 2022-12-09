package com.pace.soccerteam.service;

import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.pace.soccerteam.beans.User;
import com.pace.soccerteam.repo.UserInfoRepository;

@Component
public class PlayerServiceImpl implements PlayerService {
	
	
	@Autowired
	private UserInfoRepository userRepository;


//	@Override
//	public Set<User> findByPlayerQuery(String playername) {
//		// TODO Auto-generated method stub
//		
//		
//		
//		
//		User user = userRepository.findByUsername(playername).get();
//		return UserDetailsImpl.build(user);
//		
//	}


	@Override
	public Set<User> findPlayerByQuery(String playername) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


	

}
