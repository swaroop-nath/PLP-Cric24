package com.cg.cric24.stadium_service.web;

import java.util.List;

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


import com.cg.cric24.stadium_service.entity.StadiumBean;
import com.cg.cric24.stadium_service.exception.StadiumNotFoundException;
import com.cg.cric24.stadium_service.service.IStadiumService;


@RestController
@RequestMapping("/stadium")
@CrossOrigin(origins = "http://localhost:4200")
public class StadiumController {

	@Autowired
	IStadiumService service;
	
	@PostMapping(value = "/add",produces = "application/json",consumes = "application/json")
	public StadiumBean addStadium(@RequestBody StadiumBean stadium) {
		return service.addStadium(stadium);
	}
	
	
	@GetMapping(value = "/id/{stadiumId}",produces = "application/json")
	public StadiumBean fetchById(@PathVariable int stadiumId) throws StadiumNotFoundException {
		return service.fetchById(stadiumId);
	}
	
	@GetMapping(value = "/name/{stadiumName}",produces = "application/json")
	public List<StadiumBean> fetchByName(@PathVariable String stadiumName) throws StadiumNotFoundException {
		return service.fetchByName(stadiumName);
	}
	
	@GetMapping(value = "/all",produces = "application/json")
	public List<StadiumBean> fetchAll() throws StadiumNotFoundException {
		return service.fetchAll();
	}
	
	@PutMapping(value = "/update",consumes = "application/json",produces = "application/json")
	public StadiumBean updateStadium(@RequestBody StadiumBean stadium) {
		return service.updateStadium(stadium);
	}

	@DeleteMapping(value = "/delete/{stadiumId}")
	public Boolean deleteStadium(@PathVariable int stadiumId) throws StadiumNotFoundException {
		return service.deleteStadium(stadiumId);
	}
}
