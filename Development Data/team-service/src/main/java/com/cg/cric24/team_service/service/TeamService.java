package com.cg.cric24.team_service.service;

import java.util.List;

import com.cg.cric24.team_service.entity.Team;
import com.cg.cric24.team_service.exception.TeamNotFoundException;


public interface TeamService {
	
	String TEAM_NAME_RULE = "[A-Z][a-zA-Z]*";
	
 	String RANKINGS_RULE = "[0-9]{1,2}";
 	
 	String LEAGUE_RULE = "[A-Z][a-zA-Z]*";
 	
	Team addTeam(Team teams);

	List<Team> getAllTeams();

	Team getTeamById(int teamId) throws TeamNotFoundException;

	List<Team> getTeambyName(String teamName) throws TeamNotFoundException;

	Team updateTeams(Team teams);

	boolean deleteTeam(int teamId) throws TeamNotFoundException;
	
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
