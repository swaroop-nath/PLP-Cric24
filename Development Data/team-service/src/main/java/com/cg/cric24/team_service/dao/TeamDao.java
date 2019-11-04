package com.cg.cric24.team_service.dao;

import java.util.List;

import com.cg.cric24.team_service.entity.Team;
import com.cg.cric24.team_service.exception.TeamNotFoundException;

public interface TeamDao {

	Team addTeam(Team teams);

	List<Team> getAllTeams();

	Team getTeamById(int teamId) throws TeamNotFoundException;

	List<Team> getTeambyName(String teamName) throws TeamNotFoundException;

	Team updateTeams(Team teams);

	boolean deleteTeam(int teamId) throws TeamNotFoundException;
}
