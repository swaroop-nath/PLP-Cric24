package com.cg.cric24.schedules_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cric24.schedules_service.entity.Match;
import com.cg.cric24.schedules_service.entity.MatchStatus;
import com.cg.cric24.schedules_service.exception.ScheduleServicingException;
import com.cg.cric24.schedules_service.repository.SchedulesRepo;
import com.cg.cric24.schedules_service.repository.SchedulesRepository;
@Service
@Transactional(rollbackFor = ScheduleServicingException.class)
public class ScheduleServiceImpl implements SchedulesService {
	
	@Autowired
	private SchedulesRepository repo;

	@Override
	public Match addMAtch(Match newMatch) throws ScheduleServicingException {
		return repo.saveMatch(newMatch);
	}

	@Override
	public Match updateMatch(Match newMatch) throws ScheduleServicingException {
		return repo.updateMatchDetails(newMatch);
	}

	@Override
	public List<Match> listAllMatches() throws ScheduleServicingException {
		return repo.listAllScheduledMatches();
	}

	@Override
	public boolean updateStatus(int id, MatchStatus status) throws ScheduleServicingException {
		return repo.updateStatusOfMatch(id, status);		
	}

	@Override
	public List<Match> getMatchesByDate(LocalDateTime date) throws ScheduleServicingException {
		return repo.getByDate(date);
	}

}
