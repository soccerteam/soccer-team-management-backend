package com.pace.soccerteam.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@GetMapping("/hello")
	public String firstPage() {
		return "Hello World";
	}

}
