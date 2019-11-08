package com.cg.cric24.team_service.service;

/**
 * THis is service class implementing service layer returning the value from dao layer.
 * @author Pranav 
 * @version 1.0
 */
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cric24.team_service.dao.TeamDao;
import com.cg.cric24.team_service.dao.TeamDaoImpl;
import com.cg.cric24.team_service.entity.Team;
import com.cg.cric24.team_service.exception.TeamNotFoundException;
@Service
@Transactional (rollbackFor = TeamNotFoundException.class )
public class TeamServiceImpl implements TeamService {
	
	static Logger serviceLogger = Logger.getLogger(TeamDaoImpl.class);

	@Autowired
	private TeamDao dao;

	@Override
	public Team addTeam(Team teams) {
		serviceLogger.info("New Team added");
		return dao.addTeam(teams);
	}

	@Override
	public List<Team> getAllTeams() {
		serviceLogger.info("Display List of all teams added");
		return dao.getAllTeams();
	}

	@Override
	public Team getTeamById(int teamId) throws TeamNotFoundException {
		serviceLogger.info("Team search by ID successful");
		return dao.getTeamById(teamId);
	}

	@Override
	public List<Team> getTeambyName(String teamName) throws TeamNotFoundException {
		serviceLogger.info("Team search by name successful");
		return dao.getTeambyName(teamName);
	}

	@Override
	public Team updateTeams(Team teams) {
		serviceLogger.info("Team Updated Successfully");
		return dao.updateTeams(teams);
	}

	@Override
	public boolean deleteTeam(int teamId) throws TeamNotFoundException {
		serviceLogger.info("Team deleted successfully");
		return dao.deleteTeam(teamId);
		}
	}




