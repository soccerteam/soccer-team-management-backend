package com.pace.soccerteam.utils;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.pace.soccerteam.email.EmailService;

public class MailUtils {
	
	@Autowired
	EmailService emailService;
	
	public static String generateVerificationCode() {
		Random random = new Random();
		int number = random.nextInt(999999);
		return String.format("%06d", number);
	}

}
