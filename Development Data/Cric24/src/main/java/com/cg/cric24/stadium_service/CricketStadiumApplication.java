package com.cg.cric24.stadium_service;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CricketStadiumApplication {
	
	static Logger myLogger = Logger.getLogger(CricketStadiumApplication.class);

	public static void main(String[] args) {

		PropertyConfigurator.configure("src/log4j.properties");
		SpringApplication.run(CricketStadiumApplication.class, args);
	}

}
