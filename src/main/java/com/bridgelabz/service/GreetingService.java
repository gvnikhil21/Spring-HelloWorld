package com.bridgelabz.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.model.Greeting;
import com.bridgelabz.model.User;
import com.bridgelabz.repository.GreetingRepository;

@Service
public class GreetingService implements IGreetingService {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private GreetingRepository greetingRepository;

	@Override
	public Greeting addGreeting(User user) {
		String message = (user.toString().isEmpty()) ? "Hello World" : String.format(template, user.toString());
		return greetingRepository.save(new Greeting(counter.incrementAndGet(), String.format(message)));
	}

	@Override
	public Optional<Greeting> getGreetingById(long id) {
		return Optional.ofNullable(greetingRepository.findById(id)).get();
	}

	@Override
	public List<Greeting> getAllGreetings() {
		return greetingRepository.findAll();
	}

	@Override
	public Greeting editGreetingById(long id, User user) {
		String message = (user.toString().isEmpty()) ? "Hello World" : String.format(template, user.toString());
		return greetingRepository.save(new Greeting(id, String.format(message)));
	}
}
