package com.pace.soccerteam.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.mail.MessagingException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.pace.soccerteam.beans.ERole;
import com.pace.soccerteam.beans.Role;
import com.pace.soccerteam.beans.User;
import com.pace.soccerteam.email.EmailService;
import com.pace.soccerteam.repo.RoleRepository;
import com.pace.soccerteam.repo.UserInfoRepository;
import com.pace.soccerteam.security.payload.response.InviteUserResponse;
import com.pace.soccerteam.security.payload.response.MessageResponse;
import com.pace.soccerteam.security.payload.response.UserInfoResponse;
import com.pace.soccerteam.security.payload.response.UserVerifyResponse;
import com.pace.soccerteam.utils.MailUtils;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserInfoRepository userRepository;





	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username).get();
		return UserDetailsImpl.build(user);
	}

	@Transactional
	public UserInfoResponse updatePassword(String username, String verificationCode, String password, String fname, String lname) {

		String newPassword = password.trim();

		User userDetails = userRepository.findByUsername(username.trim()).get();
		
		
		if (userDetails.getFirstName() == null) {
			userDetails.setFirstName(fname);
		}
		if (userDetails.getLastName() == null) {
			userDetails.setLastName(lname);
		}
		
		
		
		
		if (userDetails.getVerificationCode().equals(verificationCode)) {

			userDetails.setVerified(true);
			userDetails.setPassword(password);
			userDetails.setVerificationCode(null);

			userRepository.save(userDetails);
		}
		
		
	

		Set<Role> userRoles = userDetails.getRoles();
		List<String> roles = new ArrayList<String>();

		for (Role role : userRoles) {
			ERole currentRole = role.getName();
			roles.add(String.valueOf(currentRole));
		}

		return new UserInfoResponse(userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(),
				userDetails.getFirstName(), userDetails.getLastName(), roles, userDetails.isVerified());

	}

	@Transactional
	public UserVerifyResponse updateVerificationStatus(String user, String verificationCode) {
		String newUsername = user.trim();
		User userDetails = userRepository.findByUsername(newUsername).get();

		if ((userDetails.getVerificationCode().equals(verificationCode))) {
			// userDetails.setVerified(true);
			// userRepository.save(userDetails);

			return new UserVerifyResponse(true);

		} else {
			return new UserVerifyResponse(false);

		}

//		  Set<Role> userRoles = userDetails.getRoles();
//		  List<String> roles = new ArrayList<String>();
//		  
//		  for (Role role : userRoles) {
//			ERole currentRole = role.getName();
//			roles.add(String.valueOf(currentRole));
//		}
//	

	}

}
