package com.pace.soccerteam.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pace.soccerteam.beans.User;
import com.pace.soccerteam.repo.UserInfoRepository;
import com.pace.soccerteam.security.payload.response.UserInfoResponse;

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
	
	@Override
	public UserInfoResponse getPlayerById(long id) {
		User user = userRepository.findById(id).get();
		List<String> roles = user.getRoles().stream().map(role -> String.valueOf(role.getName())).collect(Collectors.toList());
		return new UserInfoResponse(user.getId(), user.getUsername(), user.getEmail(), user.getFirstName(), user.getLastName(), roles, user.isVerified());
	}
	
	


	

}
