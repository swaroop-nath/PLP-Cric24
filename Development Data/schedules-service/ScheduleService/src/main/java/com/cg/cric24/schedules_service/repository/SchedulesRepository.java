package com.cg.cric24.schedules_service.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.cric24.schedules_service.entity.Match;
import com.cg.cric24.schedules_service.entity.MatchStatus;
import com.cg.cric24.schedules_service.entity.Stadium;
import com.cg.cric24.schedules_service.entity.Team;
import com.cg.cric24.schedules_service.exception.MatchCouldNotBeAddedException;

public interface SchedulesRepository {
	
	List<Team> getAllTeams(LocalDateTime date);
	
	Stadium getAllStadiums(LocalDateTime date);
	
	Match saveMatch(Match newMatch);
	
	Match updateMatchDetails(Match newMatch) throws MatchCouldNotBeAddedException;
	
	List<Match> listAllScheduledMatches();
	
	boolean updateStatusOfMatch(int id, MatchStatus status);

}
