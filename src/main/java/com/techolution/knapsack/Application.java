package com.techolution.knapsack;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author saikiran
 *
 */
@SpringBootApplication
public class Application {

	@Autowired
	private static Solution solution;
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(Application.class);
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(Application.class, args);
		
		// call knapsack function it returns maximum satisfaction
		LOGGER.info("Maximum satisfaction : "+Solution.knapsack());
		
		// terminate application
		LOGGER.info("Terminating application");
		System.exit(0);
	}
}
