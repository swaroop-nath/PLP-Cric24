package com.cg.Cric24.Player_Service.service;

import java.util.List;

import com.cg.Cric24.Player_Service.entity.Player;
import com.cg.Cric24.Player_Service.exception.PlayerNotfoundException;

public interface PlayerService {
	
	Player addPlayer(Player player);

	List<Player> getAllPlayers();

	Player getPlayerById(int id) throws PlayerNotfoundException;

	List<Player> getPlayer(String name) throws PlayerNotfoundException;

	Player updatePlayer(Player player);

	boolean deletePlayer(int id) throws PlayerNotfoundException;
	
}
