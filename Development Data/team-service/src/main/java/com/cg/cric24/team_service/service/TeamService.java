package com.cg.cric24.team_service.service;

/**
 * This is the interface of the service layer
 * 
 * @author Pranav
 * @Version 1.0
 * 
 * */

import java.util.List;

import com.cg.cric24.team_service.entity.Team;
import com.cg.cric24.team_service.exception.TeamNotFoundException;


public interface TeamService {
	
	String TEAM_NAME_RULE = "[A-Z][a-zA-Z]*";
	
 	String RANKINGS_RULE = "[0-9]{1,2}";
 	
 	String LEAGUE_RULE = "[A-Z][a-zA-Z]*";
 	
	Team addTeam(Team teams);
	
	/**
	 * This method is used to retrieve the list of teams added
	 * @return It returns a list Team objects 
	 */
	List<Team> getAllTeams();

	/**
	 * This method is used to fetch a team on the basis of team ID
	 * @param teamId
	 * @return It returns a Team object 
	 * @throws TeamNotFoundException
	 */
	Team getTeamById(int teamId) throws TeamNotFoundException;

	/**
	 * This method is used to fetch teams on the basis of team name
	 * @param teamName
	 * @return It returns a list of Team objects 
	 * @throws TeamNotFoundException
	 */
	List<Team> getTeambyName(String teamName) throws TeamNotFoundException;

	/**
	 * This method is used to update a Team details
	 * @param teams
	 * @return It returns a Team object
	 */
	Team updateTeams(Team teams);

	/**
	 * This method is used to delete a Team
	 * @param teamId
	 * @return it returns true if team is deleted, else it returns false
	 * @throws TeamNotFoundException
	 */
	boolean deleteTeam(int teamId) throws TeamNotFoundException;
	
	/**
	 * This method is used to validate Team details on certain parameters.
	 * @param teamName
	 * @return It returns true if validation is successful,else false
	 */
	default boolean validateTeamName(String teamName) {
		return teamName.matches(TEAM_NAME_RULE);
	}
		default boolean validateRankings(String ranking) {
			return ranking.matches(RANKINGS_RULE);
			
		}
		default boolean validateLeagueName(String leagues) {
			return leagues.matches(LEAGUE_RULE);
		}

}
