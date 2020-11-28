package com.bridgelabz.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GREETINGS")
public class Greeting {
	// variables
	@Id
	private final long id;
	private final String name;

	// constructor
	public Greeting() {
		id = 0;
		name = "";
	}

	public Greeting(long id, String name) {
		this.id = id;
		this.name = name;
	}

	// getters
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
