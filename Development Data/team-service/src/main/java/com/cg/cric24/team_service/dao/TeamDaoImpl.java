package com.cg.cric24.team_service.dao;

/**
 * 
 * @author Pranav
 * @version 1.0
 * 
 * */

import java.util.List;


import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cric24.team_service.entity.Team;
import com.cg.cric24.team_service.exception.TeamNotFoundException;

@Repository
public class TeamDaoImpl implements TeamDao {
	
	static Logger daoLogger = Logger.getLogger(TeamDaoImpl.class);
	
	@Autowired
	private EntityManager mgr;

	@Override
	public Team addTeam(Team team) {
		Team savedTeam = mgr.merge(team);
		mgr.flush();
		daoLogger.info("New Team added");
		return savedTeam;
	}

	@Override
	public List<Team> getAllTeams() {
		daoLogger.info("Display List of all teams added");
		return mgr.createNamedQuery("allteams").getResultList();
	}

	@Override
	public Team getTeamById(int teamId) throws TeamNotFoundException {
		Team t = mgr.find(Team.class, teamId);
		if (t == null) {
			daoLogger.error("Invalid team ID to search");
			throw new TeamNotFoundException("No Team Found for Id: " + teamId);
			
		}
		
		daoLogger.info("Team search by ID successful");
		return t;
	}

	@Override
	public List<Team> getTeambyName(String teamName) throws TeamNotFoundException {
   List <Team> t = (List<Team>) mgr.createNamedQuery("teambyName").setParameter("nam",teamName).getResultList();
		if(t.size()==0)
		{
			daoLogger.error("Invalid team name to search");
			throw new TeamNotFoundException("Team Not Found by this name" +teamName);
		}
		daoLogger.info("Team search by name successful");
		return t;
	}

	@Override
	public Team updateTeams(Team teams) {
		mgr.merge(teams);
		daoLogger.info("Team updated successfully"); 
		return teams;
	}

	@Override
	public boolean deleteTeam(int teamId) throws TeamNotFoundException {

		Team t = mgr.find(Team.class, teamId);
		if (t == null) {
			daoLogger.error("Invalid team ID to delete");
			throw new TeamNotFoundException("Invalid team Id: " + teamId);
		}
		daoLogger.info("Team Deleted Successfully");
		mgr.remove(t);
		return true;
	}

}
