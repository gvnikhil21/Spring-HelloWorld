package com.bridgelabz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.model.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}
