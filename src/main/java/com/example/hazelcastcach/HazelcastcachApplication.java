package com.example.hazelcastcach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HazelcastcachApplication {

	public static void main(String[] args) {
		SpringApplication.run(HazelcastcachApplication.class, args);
	}
}
