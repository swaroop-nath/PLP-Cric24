package com.cg.cric24.schedules_service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cric24.schedules_service.entity.Match;
import com.cg.cric24.schedules_service.entity.MatchStatus;
import com.cg.cric24.schedules_service.entity.MatchFormat;
import com.cg.cric24.schedules_service.entity.Player;
import com.cg.cric24.schedules_service.entity.RoleType;
import com.cg.cric24.schedules_service.entity.Stadium;
import com.cg.cric24.schedules_service.entity.Team;
import com.cg.cric24.schedules_service.exception.ScheduleServicingException;
import com.cg.cric24.schedules_service.service.SchedulesService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleServiceApplicationTests {
	@Autowired
	private SchedulesService service;
	
	@Autowired
	private EntityManager mgr;
			
//	@Ignore
	@Test
	public void testAdd() throws ScheduleServicingException {
		Match match = new Match();
		Player viratKohli = new Player();
		viratKohli.setPlayerId(1);
		viratKohli.setName("Kohli");
		viratKohli.setAge(30);
		viratKohli.setNationality("Indian");
		viratKohli.setRating(933);
		viratKohli.setRoleType(RoleType.BATSMAN);
		viratKohli.setRuns(11154);
		
		Team teamIndia = new Team();
		teamIndia.setTeamId(1);
		teamIndia.setTeamName("India");
		teamIndia.setFormat(MatchFormat.ODI);
		teamIndia.setLeagues("INTL");
		
		Set<Player> players = new HashSet<Player>();
		players.add(viratKohli);
		
		teamIndia.setPlayers(players);
		teamIndia.setRanking(1);
		
		Set<Team> teams = new HashSet<Team>();
		teams.add(teamIndia);
		viratKohli.setTeams(teams);
		viratKohli.setWickets(0);
		
		Team teamEngland = new Team();
		teamEngland.setTeamId(2);
		teamEngland.setTeamName("England");
		teamEngland.setFormat(MatchFormat.ODI);
		teamEngland.setLeagues("INTL");
		
		Set<Player> players2 = new HashSet<Player>();
		
		teamEngland.setPlayers(players2);
		teamEngland.setRanking(2);
		
		Stadium wankhede = new Stadium();
		wankhede.setStadiumId(1);
		wankhede.setStadiumName("Wankhede");
		wankhede.setLocation("Mumbai");
		wankhede.setCapacity(30000);
		wankhede.setCountry("India");
		
//		mgr.persist(wankhede);
//		mgr.persist(viratKohli);
//		mgr.persist(players);
//		mgr.persist(teamEngland);
//		mgr.persist(teamIndia);
	

		
		match.setMatchLeague("INTL");
		match.setMatchSchedule(LocalDateTime.now());
		match.setMatchStatus(MatchStatus.CANCELLED);
		match.setMatchFormat(MatchFormat.T20);
		match.setMatchVenue(wankhede);
		match.setTeamOne(teamIndia);
		match.setTeamTwo(teamEngland);
		
		assertEquals(11, service.addMAtch(match).getMatchID());
	}
	
	@Ignore
	@Test
	public void testList() throws ScheduleServicingException {		
		assertFalse(service.listAllMatches()==null);		
	}
	
	@Ignore
	@Test(expected = ScheduleServicingException.class)
	public void testListFalse() throws ScheduleServicingException{
		service.listAllMatches();
	}
	
	@Ignore
	@Test
	public void testUpdateStatus() throws ScheduleServicingException {
		assertTrue(service.updateStatus(11, MatchStatus.FORFEITED));
		
	}
	
	@Ignore
	@Test(expected = ScheduleServicingException.class)
	public void testUpdateStausWithException() throws ScheduleServicingException {
		service.updateStatus(4, MatchStatus.FORFEITED);
	}
	
//	@Test
//	public void testUpdate() {
//		service.
//	}
//	
	

}
