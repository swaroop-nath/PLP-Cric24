package com.cg.Cric24.Player_Service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.Cric24.Player_Service.entity.Player;
import com.cg.Cric24.Player_Service.exception.PlayerNotfoundException;
/**
 * DAO interface for Data access object as persistence layer.
 * @author Akash Sarkar
 *
 */
public interface PlayerDao{
	
	/**
	 * This method is used to add a new player to the application
	 * @param player
	 * @return It returns the new player object with all its details.
	 */
	Player addPlayer(Player player);


	/**
	 * This method is used to display all the players.
	 * @return it returns the list of all the players
	 */
	List<Player> getAllPlayers();

	/**
	 * This method is used to fetch a player based on his ID.
	 * @param id
	 * @return returns details of player if found else displays error
	 * @throws PlayerNotfoundException
	 */
	Player getPlayerById(int id) throws PlayerNotfoundException;

	/**
	 * This method is used to fetch a list of players based on his name.
	 * @param name
	 * @return returns the list of all players with the name given and error if not found
	 * @throws PlayerNotfoundException
	 */
	List<Player> getPlayer(String name) throws PlayerNotfoundException;

	/**
	 * This method is used to update details of a player to the application
	 * @param player
	 * @return returns the updated details of player
	 */
	Player updatePlayer(Player player);
	
	/**
	 * This method is used to delete a player from the application
	 * @param id
	 * @return returns true if player gets deleted else displays error
	 * @throws PlayerNotfoundException
	 */
	boolean deletePlayer(int id) throws PlayerNotfoundException;

}
