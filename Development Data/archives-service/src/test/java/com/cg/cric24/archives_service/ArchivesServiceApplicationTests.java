package com.cg.cric24.archives_service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.cric24.archives_service.controller.ArchivesServiceController;
import com.cg.cric24.archives_service.entity.Match;
import com.cg.cric24.archives_service.entity.MatchStatus;
import com.cg.cric24.archives_service.entity.MatchFormat;
import com.cg.cric24.archives_service.entity.Player;
import com.cg.cric24.archives_service.entity.RoleType;
import com.cg.cric24.archives_service.entity.ScoreCard;
import com.cg.cric24.archives_service.entity.Stadium;
import com.cg.cric24.archives_service.entity.Team;
import com.cg.cric24.archives_service.exception.NoMatchFoundException;
import com.cg.cric24.archives_service.service.ArchivesService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArchivesServiceApplicationTests {
	
	@Autowired private ArchivesServiceController controller;
	@Autowired private ArchivesService service;

	/* 
	 * Test case to test if all dependency injection succeeds,
	 * and the application loads successfully.
	 */
	@Ignore
	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}
	
	@Ignore
	@Test(expected = NoMatchFoundException.class)
	public void testGetListOfMatchesByTeamWithException() throws NoMatchFoundException {
		Team teamAustralia = new Team();
		teamAustralia.setTeamId(3);
		teamAustralia.setTeamName("Australia");
		teamAustralia.setFormat(MatchFormat.ODI);
		teamAustralia.setLeagues("INTL");
		teamAustralia.setPlayers(new ArrayList<Player>());
		teamAustralia.setRanking(3); 
		List<Match> matchesByAus = service.getListOfMatchesByTeam(teamAustralia);
	}
	
	@Ignore
	@Test
	public void testGetListOfMatchesByTeam() throws NoMatchFoundException {
		Team teamIndia = new Team();
		teamIndia.setTeamId(1);
		teamIndia.setTeamName("India");
		teamIndia.setFormat(MatchFormat.ODI);
		teamIndia.setLeagues("INTL");
		teamIndia.setPlayers(new ArrayList<Player>());
		teamIndia.setRanking(3); 
		List<Match> matchesByInd = service.getListOfMatchesByTeam(teamIndia);
		
		assertEquals(2, matchesByInd.size());
	}
	
//	@Ignore
	@Test
	public void testListAllMatches() throws NoMatchFoundException {
		List<Match> fetchedMatches = service.listAllMatches();
		assertEquals(3, fetchedMatches.size());
	}
	
//	@Ignore
	@Test
	public void testAddMatchDetails() {
		Player viratKohli = new Player();
		viratKohli.setPlayerId(1);
		viratKohli.setName("Virat Kohli");
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
		
		List<Player> players = new ArrayList<Player>();
		players.add(viratKohli);
		
		teamIndia.setPlayers(players);
		teamIndia.setRanking(1);
		
		List<Team> teams = new ArrayList<Team>();
		teams.add(teamIndia);
		viratKohli.setTeams(teams);
		viratKohli.setWickets(0);
		
		Team teamEngland = new Team();
		teamEngland.setTeamId(2);
		teamEngland.setTeamName("England");
		teamEngland.setFormat(MatchFormat.ODI);
		teamEngland.setLeagues("INTL");
		
		List<Player> players2 = new ArrayList<Player>();
		
		teamEngland.setPlayers(players2);
		teamEngland.setRanking(2);
		
		Stadium wankhede = new Stadium();
		wankhede.setStadiumId(1);
		wankhede.setStadiumName("Wankhede");
		wankhede.setLocation("Mumbai");
		wankhede.setCapacity(30000);
		
		ScoreCard score = new ScoreCard();
		
		score.setTeamOne(teamIndia);
		score.setTeamOneOvers(50);
		score.setTeamOneScore(321);
		score.setTeamOneWickets(7);
		score.setTeamTwo(teamEngland);
		score.setTeamTwoOvers(49.1);
		score.setTeamTwoScore(284);
		score.setTeamTwoWickets(10);
		score.setPlayerOfTheMatch(viratKohli);
		
		Match match = new Match();
		
		match.setMatchLeague("INTL");
		match.setMatchSchedule(LocalDateTime.now());
		match.setMatchScoreCard(score);
		match.setMatchStatus(MatchStatus.CONCLUDED);
		match.setMatchFormat(MatchFormat.ODI);
		match.setMatchVenue(wankhede);
		match.setTeamOne(teamIndia);
		match.setTeamTwo(teamEngland);
		
		match.setWinningTeam(teamEngland);
		
		Match savedMatch = service.addMatchDetails(match);
		
		assertEquals(2, savedMatch.getMatchID());
	}

	@Ignore
	@Test
	public void testUpdateMatchDetails() throws NoMatchFoundException {
		List<Match> matches = service.listAllMatches();
		Match matchOne = matches.get(0);
		
		matchOne.setMatchFormat(MatchFormat.TEST);
		
		service.updateMatchDetails(matchOne);
	}
	
}
