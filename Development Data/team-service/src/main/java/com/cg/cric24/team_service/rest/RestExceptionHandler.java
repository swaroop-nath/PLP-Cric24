package com.cg.cric24.team_service.rest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.cric24.team_service.exception.TeamNotFoundException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(TeamNotFoundException.class)
	@ResponseBody
	public ResponseEntity<Object> handleInvalidProduct(TeamNotFoundException prod) {
		System.out.println("Exception: " + prod.getMessage());
		return new ResponseEntity<>(prod.getMessage(), HttpStatus.NOT_FOUND);
	}
}
