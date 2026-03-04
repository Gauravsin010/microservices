package com.microservices.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Started iin port 8001");
	}
}
