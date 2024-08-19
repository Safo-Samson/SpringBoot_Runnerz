package com.safosamson.runnerz;

import com.safosamson.runnerz.run.Location;
import com.safosamson.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class RunnerzApplication {

	private static final Logger logger = LoggerFactory.getLogger(RunnerzApplication.class);
	public static void main(String[] args) {
	 SpringApplication.run(RunnerzApplication.class, args);

	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			logger.info("Welcome to Runnerz App!");
			Run run = new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR);
			logger.info("Run: {}", run);
		};
	}

}
