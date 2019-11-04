package com.cg.cric24.schedules_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cric24.schedules_service.entity.Match;
import com.cg.cric24.schedules_service.entity.MatchStatus;
import com.cg.cric24.schedules_service.repository.SchedulesRepo;
@Service
@Transactional
public class ScheduleServiceImpl implements SchedulesService {
	
	@Autowired
	private SchedulesRepo repo;

	@Override
	public Match addMAtch(Match newMatch) {
		return repo.save(newMatch);
	}

	@Override
	public Match updateMatch(Match newMatch) {
		return repo.save(newMatch);
	}

	@Override
	public List<Match> listAllMatches() {
		return repo.findAll();
	}

	@Override
	public boolean updateStatus(int id, MatchStatus status) {
		Match matchById =  repo.findById(id).get();
		if(matchById== null) {
			return false;
		}
		else
			matchById.setMatchStatus(status);
			repo.save(matchById);
			return true;
		
	}

}
