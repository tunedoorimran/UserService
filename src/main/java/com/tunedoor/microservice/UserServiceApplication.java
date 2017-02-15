package com.tunedoor.microservice;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * 
 * @author Mohamed Saeed
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

	private static Logger logger = Logger.getLogger(UserServiceApplication.class.getName());
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "user-server");
		logger.info("Change Application Configuration to use user-server.yml");
		SpringApplication.run(UserServiceApplication.class, args);
	}
}
