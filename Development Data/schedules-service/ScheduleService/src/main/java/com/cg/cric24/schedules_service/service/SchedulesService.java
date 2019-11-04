package com.cg.cric24.schedules_service.service;

import java.util.List;

import com.cg.cric24.schedules_service.entity.Match;
import com.cg.cric24.schedules_service.entity.MatchStatus;

public interface SchedulesService {
	
	Match addMAtch(Match newMatch);
	
	Match updateMatch(Match newMatch);
	
	List<Match> listAllMatches();
	
	boolean updateStatus(int id, MatchStatus status);

}
