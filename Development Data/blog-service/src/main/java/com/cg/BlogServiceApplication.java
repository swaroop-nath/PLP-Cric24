package com.cg;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BlogServiceApplication {
	
	static Logger myLogger = Logger.getLogger(BlogServiceApplication.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure("src/main/java/log4j.properties");
		SpringApplication.run(BlogServiceApplication.class, args);
	}

}
