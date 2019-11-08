package com.cg.cric24.team_service.rest;

/**
 * The controller controls the data flow into model object and 
 * updates the view whenever data changes. It keeps view and model separate
 * 
 * @author Pranav
 * @Version 1.0
 * 
 * */

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cric24.team_service.dao.TeamDaoImpl;
import com.cg.cric24.team_service.entity.Team;
import com.cg.cric24.team_service.exception.TeamNotFoundException;
import com.cg.cric24.team_service.service.TeamService;

@RestController
@RequestMapping("/team")
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {

	static Logger controllerLogger = Logger.getLogger(TeamDaoImpl.class);

	@Autowired
	TeamService service;

	/*
	 * 
	 * @Access-URL- http://localhost:8888/team/add
	 * 
	 */
	@PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
	public Team addTeam(@Valid @RequestBody Team team) {
		controllerLogger.info("Team added successfully");
		return service.addTeam(team);
	}

	/*
	 * 
	 * @Access-URL- http://localhost:8888/team/all
	 * 
	 */
	@GetMapping(value = "/all", produces = "application/json")
	public List<Team> fetchAll() {
		controllerLogger.info("displayed List of all teams added");
		return service.getAllTeams();
	}

	/*
	 * 
	 * @Access-URL- http://localhost:8888/team/name/CSK
	 * 
	 */
	@GetMapping(value = "/name/{teamName}", produces = "application/json")
	public List<Team> fetchByName(@PathVariable String teamName) throws TeamNotFoundException {
		controllerLogger.info("Team search by name successfully");
		try {
			return service.getTeambyName(teamName);
		} catch (TeamNotFoundException e) {
			e.setUriDetails("uri=/team/ID/ " + teamName);
			throw e;
		}
	}

	/*
	 * 
	 * @Access-URL- http://localhost:8888/team/id/5
	 * 
	 */
	@GetMapping(value = "/id/{teamId}", produces = "application/json")
	public Team fetchById(@PathVariable int teamId) throws TeamNotFoundException {
		controllerLogger.info("Team search by ID successful");
		try {
			return service.getTeamById(teamId);
		} catch (TeamNotFoundException e) {
			e.setUriDetails("uri=/team/ID/ " + teamId);
			throw e;
		}
	}

	/*
	 * 
	 * @Access-URL- http://localhost:8888/team/update
	 * 
	 */
	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public Team updateTeam(@RequestBody Team teams) {
		controllerLogger.info("Team Updated successfully");
		return service.updateTeams(teams);
	}

	/*
	 * 
	 * @Access-URL- http://localhost:8888/team/delete/6
	 * 
	 */
	@DeleteMapping(value = "/delete/{teamId}")
	public Boolean deleteTeam(@PathVariable int teamId) throws TeamNotFoundException {
		controllerLogger.info("Team deleted successfully");
		try {
			return service.deleteTeam(teamId);
		} catch (TeamNotFoundException e) {
			e.setUriDetails("uri=/team/ID/" + teamId);
			throw e;
		}
	}
}
