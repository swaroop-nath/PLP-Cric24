package com.cg.cric24.team_service.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cric24.team_service.dao.TeamDao;
import com.cg.cric24.team_service.entity.Team;
import com.cg.cric24.team_service.exception.TeamNotFoundException;
@Service
@Transactional (rollbackFor = TeamNotFoundException.class )
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamDao dao;

	@Override
	public Team addTeam(Team teams) {
		return dao.addTeam(teams);
	}

	@Override
	public List<Team> getAllTeams() {
		return dao.getAllTeams();
	}

	@Override
	public Team getTeamById(int teamId) throws TeamNotFoundException {
		return dao.getTeamById(teamId);
	}

	@Override
	public List<Team> getTeambyName(String teamName) throws TeamNotFoundException {
		return dao.getTeambyName(teamName);
	}

	@Override
	public Team updateTeams(Team teams) {
		return dao.updateTeams(teams);
	}

	@Override
	public boolean deleteTeam(int teamId) throws TeamNotFoundException {
		try {
			dao.deleteTeam(teamId);
			return true;
		} catch (Exception e) {
			throw new TeamNotFoundException("No player found with current id: " + teamId);
		}
	}

}


