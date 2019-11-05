package com.cg.cric24.schedules_service.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.cric24.schedules_service.entity.Match;
import com.cg.cric24.schedules_service.entity.MatchStatus;
import com.cg.cric24.schedules_service.entity.Stadium;
import com.cg.cric24.schedules_service.entity.Team;
import com.cg.cric24.schedules_service.exception.ScheduleServicingException;

public interface SchedulesRepository {
	
	
	List<Match> getByDate(LocalDateTime date) throws ScheduleServicingException;
	
	Match saveMatch(Match newMatch) throws ScheduleServicingException;
	
	Match updateMatchDetails(Match newMatch) throws ScheduleServicingException;
	
	List<Match> listAllScheduledMatches() throws ScheduleServicingException;
	
	boolean updateStatusOfMatch(int id, MatchStatus matchStatus) throws ScheduleServicingException;

}
