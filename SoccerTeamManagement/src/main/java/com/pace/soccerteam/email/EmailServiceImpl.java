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
		messageHelper.setFrom("stms.proj@gmail.com");
		messageHelper.setText("<!DOCTYPE html> <html> <head> <link href=\"https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap\" rel=\"stylesheet\"> <style > body{ font-family: 'Montserrat', sans-serif; background-color: #000000; color : purple; font-weight: bold; } </style> </head> <body> <center> <div  style=\"  padding: 100px;  background-color: #dddddd;\">Hello, Can you verify your email address for me? <br/> <a href=\"http://localhost:3000/verify?email="+to+"&code=" + verificationCode +"\" style=\"text-decoration: none; margin-top: 50px; color: purple;\"> <div style=\"width: 150px; margin-top: 50px; height: 50px;background-color: rgb(255, 197, 58); justify-content: center; align-items: center; border-radius: 50px; text-align: center; align-self: center; display: flex;\"> verify </div> </a></div> </center> </body> </html> ", true);
		emailSender.send(mimeMessage);
	}
	

}
