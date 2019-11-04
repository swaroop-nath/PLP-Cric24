package com.cg.cric24.team_service.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cric24.team_service.entity.Team;
import com.cg.cric24.team_service.exception.TeamNotFoundException;

@Repository
public class TeamDaoImpl implements TeamDao {
	@Autowired
	private EntityManager mgr;

	@Override
	public Team addTeam(Team teams) {
		mgr.persist(teams);
		return teams;
	}

	@Override
	public List<Team> getAllTeams() {

		return mgr.createNamedQuery("All Teams").getResultList();
	}

	@Override
	public Team getTeamById(int teamId) throws TeamNotFoundException {
		Team t = mgr.find(Team.class, teamId);
		if (t == null)
			throw new TeamNotFoundException("No Team Found for Id: " + teamId);
		return t;
	}

	@Override
	public List<Team> getTeambyName(String teamName) throws TeamNotFoundException {
   List <Team> t = (List<Team>) mgr.createNamedQuery("teambyName").setParameter("nam",teamName).getResultList();
		if(t.size()==0)
		{
			throw new TeamNotFoundException("Team Not Found by this name" +teamName);
		}
		return t;
	}

	@Override
	public Team updateTeams(Team teams) {
		mgr.merge(teams);
		return teams;
	}

	@Override
	public boolean deleteTeam(int teamId) throws TeamNotFoundException {

		Team t = mgr.find(Team.class, teamId);
		if (t == null)
			throw new TeamNotFoundException("Invalid team Id: " + teamId);
		mgr.remove(t);
		return true;
	}

}
