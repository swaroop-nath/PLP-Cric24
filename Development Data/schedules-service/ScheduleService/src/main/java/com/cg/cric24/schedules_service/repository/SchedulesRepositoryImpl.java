package com.cg.cric24.schedules_service.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cric24.schedules_service.entity.Match;
import com.cg.cric24.schedules_service.entity.MatchStatus;
import com.cg.cric24.schedules_service.entity.Stadium;
import com.cg.cric24.schedules_service.entity.Team;
import com.cg.cric24.schedules_service.exception.MatchCouldNotBeAddedException;

@Repository
public class SchedulesRepositoryImpl implements SchedulesRepository {

	@Autowired
	private EntityManager repoLink;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Team> getAllTeams(LocalDateTime date) {
		List<Team> teams = new ArrayList<Team>();
		teams = (List<Team>) repoLink.createNamedQuery("allTeams");
		
		return teams;
	}

	@Override
	public Stadium getAllStadiums(LocalDateTime date) {
		return null;
	}

	@Override
	public Match saveMatch(Match newMatch) {
		repoLink.persist(newMatch);
		return newMatch;
	}

	@Override
	public Match updateMatchDetails(Match newMatch) throws MatchCouldNotBeAddedException {
		int id = newMatch.getMatchID();
		Match match = repoLink.find(Match.class, id);
		if(match == null) {
			throw new MatchCouldNotBeAddedException("Match does not exists!!");
		}
		else {
			return newMatch;
		}
		
	}

	@Override
	public List<Match> listAllScheduledMatches() {
		return null;
	}

	@Override
	public boolean updateStatusOfMatch(int id, MatchStatus status) {
		return false;
	}

}
