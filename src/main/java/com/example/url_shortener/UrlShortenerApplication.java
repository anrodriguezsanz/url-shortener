package com.example.url_shortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the URL Shortener Spring Boot application.
 */
@SpringBootApplication
public class UrlShortenerApplication {

	/**
	 * Main method to start the application.
	 *
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(UrlShortenerApplication.class, args);
	}

}
