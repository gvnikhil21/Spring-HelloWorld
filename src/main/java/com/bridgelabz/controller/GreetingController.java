package com.bridgelabz.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
	public String greeting() {
		return "<h2>Welcome to Home Page!</h2>";
	}

	@GetMapping(value = "/add")
	public Greeting addGreeting(@RequestParam(value = "fName", defaultValue = "") String fName,
			@RequestParam(value = "lName", defaultValue = "") String lName) {
		User user = new User();
		user.setFirstName(fName);
		user.setLastName(lName);
		return greetingService.addGreeting(user);
	}

	@GetMapping(value = "/get")
	public Optional<Greeting> getGreeting(@RequestParam(value = "id", defaultValue = "") Long id) {
		try {
			return greetingService.getGreetingById(id);
		} catch (NullPointerException | NoSuchElementException e) {
			return Optional.empty();
		}
	}

	@GetMapping(value = "/getAll")
	public List<Greeting> getAllGreeting() {
		return greetingService.getAllGreetings();
	}

	@GetMapping(value = "/edit")
	public String editGreeting(@RequestParam(value = "id", defaultValue = "") Long id,
			@RequestParam(value = "fName", defaultValue = "") String fName,
			@RequestParam(value = "lName", defaultValue = "") String lName) {
		try {
			greetingService.getGreetingById(id);
		} catch (NullPointerException | NoSuchElementException e) {
			return "<center><h2><font color=red>Not Updated!</font></h2></center>";
		}
		User user = new User();
		user.setFirstName(fName);
		user.setLastName(lName);
		Greeting editedGreeting = greetingService.editGreetingById(id, user);
		return "<center>Greeting message with id: " + id + " updated.<br>Updated Greeting: "
				+ editedGreeting.getMessage() + "</center>";
	}

	@GetMapping(value = "/delete")
	public String deleteGreeting(@RequestParam(value = "id", defaultValue = "") Long id) {
		Optional<Greeting> greetingObj;
		try {
			greetingObj = greetingService.getGreetingById(id);
		} catch (NullPointerException | NoSuchElementException e) {
			return "<center><h2><font color=red>Not Deleted!</font></h2></center>";
		}
		greetingService.deleteGreetingById(id);
		return "<center>Greeting message with id: " + id + " deleted.<br>Deleted Greeting: "
				+ greetingObj.get().getMessage() + "</center>";
	}
}
