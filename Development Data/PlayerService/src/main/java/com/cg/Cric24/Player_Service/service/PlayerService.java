package com.cg.Cric24.Player_Service.service;

import java.util.List;

import com.cg.Cric24.Player_Service.entity.Player;
import com.cg.Cric24.Player_Service.exception.PlayerNotfoundException;
/**
 * Service interface for Business-logic layer
 * @author Akash Sarkar
 *
 */
public interface PlayerService {
	
	/**
	 * This service is used to add a new player to the application
	 * @param player
	 * @return It returns the new player object with all its details.
	 */
	Player addPlayer(Player player);

	/**
	 * This service is used to display all the players.
	 * @return it returns the list of all the players
	 */
	List<Player> getAllPlayers();

	/**
	 * This service is used to fetch a player based on his ID.
	 * @param id
	 * @return returns details of player if found else displays error
	 * @throws PlayerNotfoundException
	 */
	Player getPlayerById(int id) throws PlayerNotfoundException;


	/**
	 * This service is used to fetch a list of players based on his name.
	 * @param name
	 * @return returns the list of all players with the name given and error if not found
	 * @throws PlayerNotfoundException
	 */
	List<Player> getPlayer(String name) throws PlayerNotfoundException;

	/**
	 * This service is used to update details of a player to the application
	 * @param player
	 * @return returns the updated details of player
	 */
	Player updatePlayer(Player player);

	/**
	 * This service is used to delete a player from the application
	 * @param id
	 * @return returns true if player gets deleted else displays error
	 * @throws PlayerNotfoundException
	 */
	boolean deletePlayer(int id) throws PlayerNotfoundException;
	
}
