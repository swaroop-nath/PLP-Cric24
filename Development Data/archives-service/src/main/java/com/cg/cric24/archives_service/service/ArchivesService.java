package com.cg.cric24.archives_service.service;

import java.util.List;

import com.cg.cric24.archives_service.entity.Match;

public interface ArchivesService {

	List<Match> listAllMatches();
	
	List<Match> getListOfMatchesByTeam(int teamID);
	
	boolean updateMatchDetails(Match updatedMatch);
	
	int addMatchDetails(Match newMatch);
}
