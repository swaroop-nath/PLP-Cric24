package com.cg.cric24.stadium_service.web;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.cric24.stadium_service.exception.StadiumNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class RestExceptionHandler {

	@ExceptionHandler(StadiumNotFoundException.class)
	@ResponseBody
	public ResponseEntity<Object> handleInvalidStadium(StadiumNotFoundException stadium){
		System.out.println("Exception: "+stadium.getMessage());
		return new ResponseEntity<>(stadium.getMessage(), HttpStatus.NOT_FOUND);
	}
}
