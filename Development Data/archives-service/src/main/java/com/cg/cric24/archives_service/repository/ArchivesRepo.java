package com.cg.cric24.archives_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cric24.archives_service.entity.Match;
import com.cg.cric24.archives_service.entity.Team;
import com.cg.cric24.archives_service.exception.NoMatchFoundException;

public interface ArchivesRepo {

	List<Match> findAll() throws NoMatchFoundException;
	
	List<Match> getListOfMatchesByTeam(Team team) throws NoMatchFoundException;
	
	boolean updateMatchDetails(Match updatedMatch);
	
	int save(Match newMatch);
}
