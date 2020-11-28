package com.bridgelabz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.model.Greeting;
import com.bridgelabz.model.User;
import com.bridgelabz.service.IGreetingService;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	@Autowired
	private IGreetingService greetingService;

	@GetMapping(value = { "", "/", "/home" })
	public Greeting greeting(@RequestParam(value = "fName", defaultValue = "") String fName,
			@RequestParam(value = "lName", defaultValue = "") String lName) {
		User user = new User();
		user.setFirstName(fName);
		user.setLastName(lName);
		return greetingService.addGreeting(user);
	}
}
