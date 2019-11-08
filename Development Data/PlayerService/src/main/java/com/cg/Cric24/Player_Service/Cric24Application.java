package com.cg.Cric24.Player_Service;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Cric24Application {

	static Logger myLogger = Logger.getLogger(Cric24Application.class);
	
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("src/main/java/log4j.properties");
		SpringApplication.run(Cric24Application.class, args);
	}

}
