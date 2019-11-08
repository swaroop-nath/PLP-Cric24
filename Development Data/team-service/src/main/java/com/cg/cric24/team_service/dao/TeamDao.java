package com.cg.cric24.team_service.dao;

/**
 * This is the interface of the dao layer
 * 
 * @author Pranav
 * @Version 1.0
 * 
 * */

import java.util.List;

import com.cg.cric24.team_service.entity.Team;
import com.cg.cric24.team_service.exception.TeamNotFoundException;

public interface TeamDao {

	/**
	 * This method is used to add a new team
	 * @param teams
	 * @return It returns a Team object 
	 */
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
}
