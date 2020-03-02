package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the starting point of the application. This class is an entry point plus configuration
 * class of the application.
 */

@SpringBootApplication
public class Application {

	/**
	   * The main method which starts the application.
	   * 
	   * @param args
	   */
	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
		
	}
	
}
