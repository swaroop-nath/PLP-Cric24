package com.cg.Cric24.Player_Service.web;

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

import com.cg.Cric24.Player_Service.entity.Player;
import com.cg.Cric24.Player_Service.exception.PlayerNotfoundException;
import com.cg.Cric24.Player_Service.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	PlayerService service;

	@PostMapping(value = "/add", produces = "application/json", consumes = "application/json")
	public Player addPlayer(@RequestBody Player player) {
		return service.addPlayer(player);
	}

	@GetMapping(value = "/all", produces = "application/json", consumes = "application/json")
	public List<Player> fetchAll() {
		return service.getAllPlayers();
	}

	@GetMapping(value = "/name/{name}", produces = "application/json", consumes = "application/json")
	public List<Player> fetchByName(@PathVariable String name) throws PlayerNotfoundException {
		return service.getPlayer(name);
	}

	@GetMapping(value = "/id/{id}", produces = "application/json", consumes = "application/json")
	public Player fetchById(@PathVariable int id) throws PlayerNotfoundException {
		return service.getPlayerById(id);
	}
	
	@PutMapping(value = "/update",consumes = "application/json",produces = "application/json")
	public Player updateProduct(@RequestBody Player player) {
		return service.updatePlayer(player);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public Boolean deleteProduct(@PathVariable int id) throws PlayerNotfoundException {
		return service.deletePlayer(id);
	}

}
