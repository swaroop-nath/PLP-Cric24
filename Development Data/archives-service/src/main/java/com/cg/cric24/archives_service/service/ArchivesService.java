package com.cg.cric24.archives_service.service;

import java.util.List;

import com.cg.cric24.archives_service.entity.Match;
import com.cg.cric24.archives_service.entity.Team;
import com.cg.cric24.archives_service.exception.NoMatchFoundException;

public interface ArchivesService {

	List<Match> listAllMatches() throws NoMatchFoundException;
	
	List<Match> getListOfMatchesByTeam(Team team) throws NoMatchFoundException;
	
	boolean updateMatchDetails(Match updatedMatch);
	
	Match addMatchDetails(Match newMatch);
}
