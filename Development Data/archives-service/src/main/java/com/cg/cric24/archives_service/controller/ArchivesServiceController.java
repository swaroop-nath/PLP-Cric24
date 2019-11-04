package com.cg.cric24.archives_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cric24.archives_service.entity.Match;
import com.cg.cric24.archives_service.service.ArchivesService;

@RestController
@RequestMapping(value = "/archives-api")
public class ArchivesServiceController {

	@Autowired private ArchivesService service;
	
	@GetMapping(value = "/list-matches", produces = "application/json")
	public List<Match> getListOfMatches() {
		return service.listAllMatches();
	}
	
	@GetMapping(value = "/list-matches/{team_id}", produces = "application/json")
	public List<Match> getListOfMatchesByTeam(@PathVariable int teamID) {
		return service.getListOfMatchesByTeam(teamID);
	}
	
	@PutMapping(value = "/update-match", consumes = "application/json")
	public boolean updateMatchDetails(@RequestBody Match updatedMatch) {
		return service.updateMatchDetails(updatedMatch);
	}
	
	@PostMapping(value = "/add-match", consumes = "application/json")
	public int addMatchDetails(@RequestBody Match newMatch) {
		return service.addMatchDetails(newMatch);
	}
	
}
