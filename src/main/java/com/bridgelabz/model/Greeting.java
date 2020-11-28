package com.bridgelabz.model;

public class Greeting {
	// variables
	private final long id;
	private final String name;

	// constructor
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
