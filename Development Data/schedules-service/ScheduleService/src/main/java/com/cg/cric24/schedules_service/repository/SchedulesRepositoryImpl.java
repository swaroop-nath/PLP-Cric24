package com.cg.cric24.schedules_service.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cric24.schedules_service.entity.Match;
import com.cg.cric24.schedules_service.entity.MatchStatus;
import com.cg.cric24.schedules_service.entity.Stadium;
import com.cg.cric24.schedules_service.entity.Team;
import com.cg.cric24.schedules_service.exception.ScheduleServicingException;

@Repository
public class SchedulesRepositoryImpl implements SchedulesRepository {

	@Autowired
	private EntityManager repoLink;
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Team> getAllTeams(LocalDateTime date) {
//		List<Team> teams = new ArrayList<Team>();
//		teams = (List<Team>) repoLink.createNamedQuery("allTeams");
//		return teams;
//	}

//	@Override
//	public Stadium getAllStadiums(LocalDateTime date) {
//		return null;
//	}

	@Override
	public Match saveMatch(Match newMatch) throws ScheduleServicingException {
		try {
			Match savedMatch = repoLink.merge(newMatch);
			repoLink.flush();
			return savedMatch;
		}
		catch(Exception e) {
			throw new ScheduleServicingException(e.getMessage());
		}
		
	}

	@Override
	public Match updateMatchDetails(Match newMatch) throws ScheduleServicingException {
		int id = newMatch.getMatchID();
		Match match = repoLink.find(Match.class, id);
		if(match == null) {
			throw new ScheduleServicingException("Match does not exists!!");
		}
		else {
			Match updatedMatch = repoLink.merge(newMatch);
			repoLink.flush();
			return updatedMatch;
		}
		
	}

	@Override
	public List<Match> listAllScheduledMatches() throws ScheduleServicingException {
		List<Match> matches = new ArrayList<Match>();		
		matches = (List<Match>) repoLink.createNamedQuery("allMatches").getResultList();
		if(matches.size()==0) {
			throw new ScheduleServicingException("No match found!!");
		}
		return matches;
	}

	@Override
	public boolean updateStatusOfMatch(int id, MatchStatus matchStatus) throws ScheduleServicingException {
		Match match = new Match();
		match = repoLink.find(Match.class, id);
		if(match==null) {
			throw new ScheduleServicingException("No Match found for this ID");
		}
		else {
			match.setMatchStatus(matchStatus);
			repoLink.merge(match);
			repoLink.flush();
			return true;
		}
		
	}

	@Override
	public List<Match> getByDate(LocalDateTime date) throws ScheduleServicingException {
		List<Match> matches = new ArrayList<Match>();
		matches = (List<Match>)repoLink.createQuery("SELECT m FROM Match m WHERE time:=date").setParameter("date", date).getResultList();
		if(matches.size()==0)
			throw new ScheduleServicingException("No Match found for this date");
		return matches;
	}

}
