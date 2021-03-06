package com.bridgelabz.service;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.model.Greeting;
import com.bridgelabz.model.User;

public interface IGreetingService {
	Greeting addGreeting(User user);

	Optional<Greeting> getGreetingById(long id);

	List<Greeting> getAllGreetings();

	Greeting editGreetingById(long id, User user);

	void deleteGreetingById(long id);
}
