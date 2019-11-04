package com.cg.cric24.archives_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cric24.archives_service.entity.Match;
import com.cg.cric24.archives_service.repository.ArchivesRepo;

@Service
public class ArchivesServiceImpl implements ArchivesService {
	
	@Autowired private ArchivesRepo repo;

	@Override
	public List<Match> listAllMatches() {
		return repo.findAll();
	}

	@Override
	public List<Match> getListOfMatchesByTeam(int teamID) {
		return null;
	}

	@Override
	public boolean updateMatchDetails(Match updatedMatch) {
		return false;
	}

	@Override
	public int addMatchDetails(Match newMatch) {
		return repo.save(newMatch).getMatchID();
	}

}
