package com.pace.soccerteam.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender emailSender;

	@Override
	public void sendSimpleMessage(String to, String subject, String text) throws MessagingException {
		
		MimeMessage mimeMessage = emailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
		messageHelper.setSubject(subject);
		messageHelper.setTo(to);
		messageHelper.setText(text);
		emailSender.send(mimeMessage);

	}
	
	@Override
	public void sendVerificationMessage(String to, String verificationCode) throws MessagingException {
		MimeMessage mimeMessage = emailSender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
		messageHelper.setSubject("Verify your email");
		messageHelper.setTo(to);
		messageHelper.setText("please verify this is the correct email address with following verification code \n" + verificationCode);
		emailSender.send(mimeMessage);
	}
	

}
