package com.cg.cric24.stadium_service.web;

/**
 * This is the controller class which controls the data flow into model object and
 * updates the view whenever data changes. It keeps view and model separate
 * 
 * @author Shagufta
 * @version 1.0
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

import com.cg.cric24.stadium_service.entity.Stadium;
import com.cg.cric24.stadium_service.exception.NoRegisteredStadiumException;
import com.cg.cric24.stadium_service.exception.StadiumNotFoundException;
import com.cg.cric24.stadium_service.service.IStadiumService;

@RestController
@RequestMapping("/stadium")
@CrossOrigin(origins = "http://localhost:4200")
public class StadiumController {

	@Autowired
	IStadiumService service;

	static Logger controllerLogger = Logger.getLogger(StadiumController.class);

	/*
	 * Access URL - "http://localhost:8890/stadium/add"
	 */
	@PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
	public Stadium addStadium(@Valid @RequestBody Stadium stadium) {
		return service.addStadium(stadium);
	}

	/*
	 * Access URL - "http://localhost:8890/stadium/id/5"
	 */
	@GetMapping(value = "/id/{stadiumId}", produces = "application/json")
	public Stadium fetchById(@PathVariable int stadiumId) throws StadiumNotFoundException {
		try {
			return service.fetchById(stadiumId);
		} catch (StadiumNotFoundException e) {
			e.setUriDetails("uri=/stadium/id/" + stadiumId);
			throw e;
		}
	}

	/*
	 * Access URL - "http://localhost:8890/stadium/name/Wankhede Stadium"
	 */
	@GetMapping(value = "/name/{stadiumName}", produces = "application/json")
	public List<Stadium> fetchByName(@PathVariable String stadiumName) throws StadiumNotFoundException {
		try {
			return service.fetchByName(stadiumName);
		} catch (StadiumNotFoundException e) {
			e.setUriDetails("uri=/stadium/name/" + stadiumName);
			throw e;
		}
	}

	/*
	 * Access URL - "http://localhost:8890/stadium/country/India"
	 */
	@GetMapping(value = "/country/{country}", produces = "application/json")
	public List<Stadium> fetchByCountry(@PathVariable String country) throws NoRegisteredStadiumException {
		try {
			return service.fetchByCountry(country);
		} catch (NoRegisteredStadiumException e) {
			e.setUriDetails("uri=/stadium/country/" + country);
			throw e;
		}
	}

	/*
	 * Access URL - "http://localhost:8890/stadium/all"
	 */
	@GetMapping(value = "/all", produces = "application/json")
	public List<Stadium> fetchAll() throws StadiumNotFoundException {
		try {
			return service.fetchAll();
		} catch (StadiumNotFoundException e) {
			e.setUriDetails("uri=/stadium/all/");
			throw e;
		}
	}

	/*
	 * Access URL - "http://localhost:8890/stadium/update"
	 */
	@PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
	public Stadium updateStadium(@RequestBody Stadium stadium) {
		return service.updateStadium(stadium);
	}

	/*
	 * Access URL - "http://localhost:8890/stadium/delete/3"
	 */
	@DeleteMapping(value = "/delete/{stadiumId}")
	public Boolean deleteStadium(@PathVariable int stadiumId) throws StadiumNotFoundException {
		System.out.println("Delete req" + stadiumId);
		try {
			return service.deleteStadium(stadiumId);
		} catch (StadiumNotFoundException e) {
			e.setUriDetails("uri=/stadium/delete/" + stadiumId);
			throw e;
		}
	}
}
