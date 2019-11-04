package com.cg.Cric24.Player_Service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.Cric24.Player_Service.entity.Player;
import com.cg.Cric24.Player_Service.exception.PlayerNotfoundException;

public interface PlayerDao{
	
	Player addPlayer(Player player);

	List<Player> getAllPlayers();

	Player getPlayerById(int id) throws PlayerNotfoundException;

	List<Player> getPlayer(String name) throws PlayerNotfoundException;

	Player updatePlayer(Player player);
	
	boolean deletePlayer(int id) throws PlayerNotfoundException;

}
