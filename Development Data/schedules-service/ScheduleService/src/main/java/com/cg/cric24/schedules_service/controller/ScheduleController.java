package com.cg.cric24.schedules_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cric24.schedules_service.entity.Match;
import com.cg.cric24.schedules_service.entity.MatchStatus;
import com.cg.cric24.schedules_service.exception.ScheduleServicingException;
import com.cg.cric24.schedules_service.service.SchedulesService;

@RestController
@RequestMapping("/schedule")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET ,RequestMethod.POST, RequestMethod.PUT})
public class ScheduleController {
	
	@Autowired
	private SchedulesService service;
	
	@PostMapping(value = "/addMatch")
	public Match addMatch(@RequestBody Match newMatch) throws ScheduleServicingException {
		return service.addMAtch(newMatch);
	}
	
	@GetMapping(value = "/getMatches", produces = "application/json")
	public List<Match> listMatches() throws ScheduleServicingException{
		return service.listAllMatches();
	}
	
	@PutMapping(value = "/updateMatch", produces = "application/json", consumes = "application/json")
	public Match updateMatch(@RequestBody Match updatedMatch) throws ScheduleServicingException {
		return service.updateMatch(updatedMatch);
	}
	
	@PutMapping(value = "/changeStatus", produces = "application/json")
	public boolean updateStatus(@RequestParam int matchId, @RequestParam MatchStatus status) throws ScheduleServicingException {
		return service.updateStatus(matchId, status);
	}
	
	

}
