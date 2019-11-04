package com.cg.cric24.archives_service.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cric24.archives_service.entity.Match;
import com.cg.cric24.archives_service.entity.Team;
import com.cg.cric24.archives_service.exception.NoMatchFoundException;
import com.cg.cric24.archives_service.repository.ArchivesRepo;

@Service
@Transactional
public class ArchivesServiceImpl implements ArchivesService {
	
	@Autowired private ArchivesRepo repo;

	@Override
	public List<Match> listAllMatches() throws NoMatchFoundException {
		return repo.findAll();
	}

	@Override
	public List<Match> getListOfMatchesByTeam(Team team) throws NoMatchFoundException {
		return repo.getListOfMatchesByTeam(team);
	}

	@Override
	public boolean updateMatchDetails(Match updatedMatch) {
		return false;
	}

	@Override
	public int addMatchDetails(Match newMatch) {
		return repo.save(newMatch);
	}

}
