package com.cg.Cric24.Player_Service.web;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.cg.Cric24.Player_Service.entity.Player;
import com.cg.Cric24.Player_Service.exception.PlayerNotfoundException;
import com.cg.Cric24.Player_Service.service.PlayerService;

/**
 * Controller controls the data flow into model object and updates the view
 * wherever data changes. It keeps view and separate.
 * 
 * @author Akash Sarkar
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/player")
public class PlayerController {
	

	@Autowired
	PlayerService service;

	static Logger controllerLogger = Logger.getLogger(PlayerController.class);

	/*
	 * Access URL - http://localhost:8889/player/add
	 */
	@PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
	public Player addPlayer(@Valid @RequestBody Player player) {
		controllerLogger.info("To add a new player");
		return service.addPlayer(player);
	}

	/*
	 * Access URL - http://localhost:8889/player/all
	 */
	@GetMapping(value = "/all", produces = "application/json")
	public List<Player> fetchAll() {
		
		controllerLogger.info("To get the list of all existing players");
		return service.getAllPlayers();
	}

	/*
	 * Access URL - http://localhost:8889/player/name/Virat Kohli
	 */
	@GetMapping(value = "/name/{name}", produces = "application/json")
	public List<Player> fetchByName(@PathVariable String name) throws PlayerNotfoundException {
		controllerLogger.info("Get all players on basis of name");
		return service.getPlayer(name);
	}

	/*
	 * Access URL - http://localhost:8889/player/id/4
	 */
	@GetMapping(value = "/id/{id}", produces = "application/json")
	public Player fetchById(@PathVariable int id) throws PlayerNotfoundException {
		controllerLogger.info("Get a player on basis of ID");
		return service.getPlayerById(id);
	}

	/*
	 * Access URL - http://localhost:8889/player/update
	 */
	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public Player updateProduct(@RequestBody Player player) {
		controllerLogger.info("Update a player as per requirement");
		return service.updatePlayer(player);
	}

	/*
	 * Access URL - http://localhost:8889/player/delete/8
	 */
	@DeleteMapping(value = "/delete/{id}")
	public Boolean deleteProduct(@PathVariable int id) throws PlayerNotfoundException {
		System.out.println("Delete called");
		controllerLogger.info("Delete a player based on given ID");
		return service.deletePlayer(id);
	}

}
