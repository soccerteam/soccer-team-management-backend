package com.pace.soccerteam.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pace.soccerteam.beans.ERole;
import com.pace.soccerteam.beans.Role;
import com.pace.soccerteam.beans.User;
import com.pace.soccerteam.email.EmailService;
import com.pace.soccerteam.repo.RoleRepository;
import com.pace.soccerteam.repo.UserInfoRepository;
import com.pace.soccerteam.security.JwtUtils;
import com.pace.soccerteam.security.payload.request.LoginRequest;
import com.pace.soccerteam.security.payload.request.SignupRequest;
import com.pace.soccerteam.security.payload.response.MessageResponse;
import com.pace.soccerteam.security.payload.response.UserInfoResponse;
import com.pace.soccerteam.security.payload.response.UserInfoWithTokenResponse;
import com.pace.soccerteam.service.UserDetailsImpl;
import com.pace.soccerteam.utils.MailUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	  @Autowired
	  AuthenticationManager authenticationManager;

	  @Autowired
	  UserInfoRepository userRepository;

	  @Autowired
	  RoleRepository roleRepository;

	  @Autowired
	  PasswordEncoder encoder;
	  
	  @Autowired
	  EmailService emailService;

	  @Autowired
	  JwtUtils jwtUtils;
	  
	  @PostMapping("/signin")
	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		  
	    Authentication authentication = authenticationManager
	        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);

	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

	    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());
	    
	    if(!userDetails.isVerified()) {
	    	return ResponseEntity.badRequest().body(new MessageResponse("Error: User is not verified! Please check your mail to verify"));
	   
	    }
	    
	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
		        .body(new UserInfoWithTokenResponse(jwtCookie.toString(),
		        		userDetails.getId(),
		                                   userDetails.getUsername(),
		                                   userDetails.getEmail(),
		                                   userDetails.getFirstName(),
		                                   userDetails.getLastName(),
		                                   roles,
		                                   userDetails.isVerified()));
		
	  }
	  
		@PostMapping("/signup")
		public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) throws MessagingException {
			if (userRepository.existsByUsername(signUpRequest.getUsername())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
			}

			if (userRepository.existsByEmail(signUpRequest.getEmail())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
			}

			// Create new user's account 
			User user = new	User(signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

			if(signUpRequest.getFirstName() != null) {
				user.setFirstName(signUpRequest.getFirstName());
			}
			if(signUpRequest.getLastName() != null) {
			user.setLastName(signUpRequest.getLastName());
			}
	
			Set<String> strRoles = signUpRequest.getRole();
			Set<Role> roles = new HashSet<>();

			if (strRoles == null) {
				Role userRole = roleRepository.findByName(ERole.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
			} else {
				strRoles.forEach(role -> {
					switch (role) {
					case "admin":
						Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(adminRole);

						break;
					default:
						Role userRole = roleRepository.findByName(ERole.ROLE_USER)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(userRole);
					}
				});
			}

			user.setRoles(roles);
			user.setVerificationCode(MailUtils.generateVerificationCode());
			emailService.sendVerificationMessage(user.getEmail(), user.getVerificationCode());
			userRepository.save(user);

			return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
		}
		
		@PostMapping("/signout")
		  public ResponseEntity<?> logoutUser() {
		    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
		    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
		        .body(new MessageResponse("You've been signed out!"));
		  }

}
