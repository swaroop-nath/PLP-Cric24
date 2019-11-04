package com.cg.cric24.team_service.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cric24.team_service.entity.Team;
import com.cg.cric24.team_service.exception.TeamNotFoundException;
import com.cg.cric24.team_service.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {
	@Autowired
	TeamService service;

	@PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
	public Team addTeam(@RequestBody Team teams) {
		return service.addTeam(teams);
	}

	@GetMapping(value = "/all", produces = "application/json", consumes = "application/json")
	public List<Team> fetchAll() {
		return service.getAllTeams();
	}

	@GetMapping(value = "/name/{teamName}", produces = "application/json", consumes = "application/json")
	public List<Team> fetchByName(@PathVariable String teamName) throws TeamNotFoundException {
		return service.getTeambyName(teamName);
	}

	@GetMapping(value = "/id/{teamId}", produces = "application/json", consumes = "application/json")
	public Team fetchById(@PathVariable int teamId) throws TeamNotFoundException {
		return service.getTeamById(teamId);
	}

	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public Team updateTeam(@RequestBody Team teams) {
		return service.updateTeams(teams);
	}

	@DeleteMapping(value = "/delete/{teamId}")
	public Boolean deleteTeam(@PathVariable int teamId) throws TeamNotFoundException {
		return service.deleteTeam(teamId);
	}

}
