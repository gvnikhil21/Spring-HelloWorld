package com.bridgelabz.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GREETINGS")
public class Greeting {
	// variable
	@Id
	private final long id;
	private final String message;

	// constructor
	public Greeting() {
		id = 0;
		message = "";
	}

	public Greeting(long id, String message) {
		this.id = id;
		this.message = message;
	}

	// getters
	public long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}
}
