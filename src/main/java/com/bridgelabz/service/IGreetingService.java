package com.bridgelabz.service;

import java.util.Optional;

import com.bridgelabz.model.Greeting;
import com.bridgelabz.model.User;

public interface IGreetingService {
	Greeting addGreeting(User user);

	Optional<Greeting> getGreetingById(long id);
}
