package com.cg.cric24.team_service;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeamServiceApplication {
	
	static Logger myLogger = Logger.getLogger(TeamServiceApplication.class);

	public static void main(String[] args) {
		
		PropertyConfigurator.configure("src/main/java/log4j.properties");
		SpringApplication.run(TeamServiceApplication.class, args);
	}

}
