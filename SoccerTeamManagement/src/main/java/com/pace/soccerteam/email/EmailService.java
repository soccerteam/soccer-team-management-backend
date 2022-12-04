package com.pace.soccerteam.email;

public interface EmailService {

    void sendSimpleMessage(String to, String subject, String text);
}
