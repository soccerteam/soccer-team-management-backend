package com.pace.soccerteam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.pace.soccerteam.*"})
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class SoccerTeamManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoccerTeamManagementApplication.class, args);
	}

}
