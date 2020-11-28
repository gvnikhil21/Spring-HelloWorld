package com.bridgelabz.service;

import com.bridgelabz.model.Greeting;
import com.bridgelabz.model.User;

public interface IGreetingService {
	Greeting addGreeting(User user);

	Greeting getGreetingById(long id);
}
