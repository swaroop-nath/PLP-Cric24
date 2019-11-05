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
import com.cg.cric24.archives_service.entity.Team;
import com.cg.cric24.archives_service.exception.NoMatchFoundException;
import com.cg.cric24.archives_service.service.ArchivesService;

@RestController
@RequestMapping(value = "/archives-api")
public class ArchivesServiceController {

	@Autowired private ArchivesService service;
	
	@GetMapping(value = "/list-matches", produces = "application/json")
	public List<Match> getListOfMatches() throws NoMatchFoundException {
		return service.listAllMatches();
	}
	
	@PostMapping(value = "/list-matches/by-team", produces = "application/json")
	public List<Match> getListOfMatchesByTeam(@RequestBody Team team) throws NoMatchFoundException {
		return service.getListOfMatchesByTeam(team);
	}
	
	@PutMapping(value = "/update-match", consumes = "application/json")
	public boolean updateMatchDetails(@RequestBody Match updatedMatch) {
		return service.updateMatchDetails(updatedMatch);
	}
	
	@PostMapping(value = "/add-match", consumes = "application/json", produces = "application/json")
	public Match addMatchDetails(@RequestBody Match newMatch) {
		return service.addMatchDetails(newMatch);
	}
	
}
