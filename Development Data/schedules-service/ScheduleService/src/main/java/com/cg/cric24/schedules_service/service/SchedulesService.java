package com.cg.cric24.schedules_service.service;

import java.time.LocalDateTime;
import java.util.List;

import com.cg.cric24.schedules_service.entity.Match;
import com.cg.cric24.schedules_service.entity.MatchStatus;
import com.cg.cric24.schedules_service.exception.ScheduleServicingException;

public interface SchedulesService {
	
	Match addMAtch(Match newMatch) throws ScheduleServicingException;
	
	Match updateMatch(Match newMatch) throws ScheduleServicingException;
	
	List<Match> listAllMatches() throws ScheduleServicingException;
	
	boolean updateStatus(int id, MatchStatus status) throws ScheduleServicingException;

	List<Match> getMatchesByDate(LocalDateTime date) throws ScheduleServicingException;
	
}
