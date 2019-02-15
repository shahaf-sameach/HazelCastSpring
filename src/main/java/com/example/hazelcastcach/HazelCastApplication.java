package com.example.hazelcastcach;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@Slf4j
@SpringBootApplication
@EnableCaching
public class HazelCastApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HazelCastApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
        log.error("ERROR");
	}
}
