package com.cg.Cric24.Player_Service.service;

import java.util.List;

import com.cg.Cric24.Player_Service.entity.Player;
import com.cg.Cric24.Player_Service.exception.PlayerNotfoundException;

public interface PlayerService {
	
	String PLAYER_NAME_RULE = "^[A-Z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{3,}$";
	
	String AGE_RULE = "^(\\d?[1-9]|[1-9]0)$";
	
	String NATIONALITY_RULE = "[A-Z][a-zA-Z ]*";
		
	String WICKETS_RULE = "[0-9]{1,3}";
	
	String RUNS_RULE = "[0-9]{1,5}";
	
	String RATING_RULE = "[0-9]{1}.[0-9]{1}";

	Player addPlayer(Player player);

	List<Player> getAllPlayers();

	Player getPlayerById(int id) throws PlayerNotfoundException;

	List<Player> getPlayer(String name) throws PlayerNotfoundException;

	Player updatePlayer(Player player);

	boolean deletePlayer(int id) throws PlayerNotfoundException;
	
	default boolean validatePlayerName(String name) {
		return name.matches(PLAYER_NAME_RULE);
	}
	
	default boolean validateAge(String age) {
		return age.matches(AGE_RULE);
	}
	
	default boolean validateNationality(String nationality) {
		return nationality.matches(NATIONALITY_RULE);
	}
	
	default boolean validateRating(String rating) {
		return rating.matches(RATING_RULE);
	}
	
	default boolean validateRuns(String runs) {
		return runs.matches(RUNS_RULE);
	}
	
	default boolean validateWickets(String wkts) {
		return wkts.matches(WICKETS_RULE);
	}
}
