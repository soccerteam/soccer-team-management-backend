package com.pace.soccerteam.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pace.soccerteam.email.EmailService;
import com.pace.soccerteam.service.UserDetailsServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

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
	  public String verifyEmail(String username, @RequestParam String verificationCode) {
		  String vc = verificationCode.trim();
		  return userDetailsService.updateVerificationStatus(username, vc);
		 
	  }

	
}
