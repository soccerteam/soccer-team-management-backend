package com.pace.soccerteam.controller;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pace.soccerteam.beans.User;
import com.pace.soccerteam.email.EmailService;
import com.pace.soccerteam.security.AuthEntryPointExceptionHandler;
import com.pace.soccerteam.security.payload.response.UserInfoResponse;
import com.pace.soccerteam.security.payload.response.UserVerifyResponse;
import com.pace.soccerteam.service.UserDetailsServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	private static final Logger logger = LoggerFactory.getLogger(TestController.class);


	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	  @GetMapping("/all")
	  public String allAccess() {
	    return "Public Content.";
	  }

	  @GetMapping("/user")
	  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	  public String userAccess() {
	    return "User Content.";
	  }

	  @GetMapping("/admin")
	  @PreAuthorize("hasRole('ADMIN')")
	  public String adminAccess() {
	    return "Admin Board.";
	  }
	  
	  @GetMapping("/sendMail")
	  public String sendMail(@RequestParam String mail) throws MessagingException {
		  emailService.sendSimpleMessage(mail, "test-mail", "Please verify your F1-status in order to continue with you Spring Semester.");
		  return "mail sent";
		  
	  }
	  
	  @PostMapping("/verify")
	  public UserVerifyResponse verify(@RequestBody ObjectNode json) {
		  
		  String username = json.get("username").asText();
		  String vcode = json.get("verificationCode").asText();

  
		  //username, @RequestBody String verificationCode
		  
		  
		
		  //String vc = verificationCode.trim();
		  return userDetailsService.updateVerificationStatus(username, vcode);
	  }

	  
	  @PostMapping("/updatePassword")
	  public UserInfoResponse verifyUpdatePassword(@RequestBody ObjectNode json) {
		  // @RequestBody User user, @RequestBody String verificationCode, @RequestBody String password
		  
		  
		  String user = json.get("username").asText();
		  String vcode = json.get("verificationCode").asText();
		  String newPassword = json.get("password").asText();

		  
		  
		  return userDetailsService.updatePassword(user, vcode, newPassword);
	  }
	
}
