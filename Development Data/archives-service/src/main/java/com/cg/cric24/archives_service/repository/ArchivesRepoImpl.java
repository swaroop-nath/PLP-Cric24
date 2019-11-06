package com.cg.cric24.archives_service.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cric24.archives_service.entity.Match;
import com.cg.cric24.archives_service.entity.Team;
import com.cg.cric24.archives_service.exception.NoMatchFoundException;

@Repository
public class ArchivesRepoImpl implements ArchivesRepo {

	@Autowired private EntityManager manager;
	
	@Override
	public List<Match> findAll() throws NoMatchFoundException {
		List<Match> fetchedMatches = manager.createNamedQuery("all_matches").getResultList();
		if (fetchedMatches.size() == 0)
			throw new NoMatchFoundException("No matches added yet in the server.\nWe will be returning with our services soon!");
		return fetchedMatches;
	}

	@Override
	public List<Match> getListOfMatchesByTeam(Team team) throws NoMatchFoundException {
		List<Match> fetchedMatches = manager.createNamedQuery("all_matches_for_team").setParameter("team", team).getResultList();
		if (fetchedMatches.size() == 0)
			throw new NoMatchFoundException("No matches exist for the team: " + team.getTeamName());
		return fetchedMatches;
	}

	@Override
	public boolean updateMatchDetails(Match updatedMatch) {
		manager.merge(updatedMatch);
		manager.flush();
		
		return true;
	}

	@Override
	public Match save(Match newMatch) {
		Match savedMatch = manager.merge(newMatch);
		manager.flush();
		return savedMatch;
	}

}
