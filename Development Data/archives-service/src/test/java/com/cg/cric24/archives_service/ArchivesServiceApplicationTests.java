package com.cg.cric24.archives_service;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.HashSet;
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
import com.cg.cric24.archives_service.entity.MatchType;
import com.cg.cric24.archives_service.entity.Player;
import com.cg.cric24.archives_service.entity.RoleType;
import com.cg.cric24.archives_service.entity.ScoreCard;
import com.cg.cric24.archives_service.entity.Stadium;
import com.cg.cric24.archives_service.entity.Team;
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
	
	@Test
	public void testSaveMatch() {
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
		teamIndia.setFormat("ODI");
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
		teamEngland.setFormat("ODI");
		teamEngland.setLeagues("INTL");
		
		Set<Player> players2 = new HashSet<Player>();
		
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
		score.setTeamTwoOvers(48.3);
		score.setTeamTwoScore(281);
		score.setTeamTwoWickets(10);
		
		Match match = new Match();
		
		match.setMatchLeague("INTL");
		match.setMatchSchedule(LocalDateTime.now());
		match.setMatchScoreCard(score);
		match.setMatchStatus(MatchStatus.CONCLUDED);
		match.setMatchType(MatchType.ODI);
		match.setMatchVenue(wankhede);
		match.setTeamOne(teamIndia);
		match.setTeamTwo(teamEngland);
		
		service.addMatchDetails(match);
	}

}
