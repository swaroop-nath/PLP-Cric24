package com.cg.cric24.team_service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.cric24.team_service.dao.TeamDao;
import com.cg.cric24.team_service.entity.MatchFormat;
import com.cg.cric24.team_service.entity.Player;
import com.cg.cric24.team_service.entity.RoleType;
import com.cg.cric24.team_service.entity.Team;
import com.cg.cric24.team_service.exception.TeamNotFoundException;
import com.cg.cric24.team_service.service.TeamService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamServiceApplicationTests {

	@Autowired
	private TeamService service;
	@Autowired
	private TeamDao dao;

	@Test
	public void testAddTeam() {

		Player viratKohli = new Player();
		viratKohli.setPlayerId(1);
		viratKohli.setName("Virat Kohli");
		viratKohli.setAge(30);
		viratKohli.setNationality("Indian");
		viratKohli.setRating(933);
		viratKohli.setRoleType(RoleType.BATSMAN);
		viratKohli.setRuns(11154);
		viratKohli.setWickets(0);

		Team teamIndia = new Team();
		teamIndia.setTeamName("India");
		teamIndia.setFormat(MatchFormat.ODI);
		teamIndia.setLeagues("INTL");
		teamIndia.setRanking(1);

		List<Player> players = new ArrayList<Player>();
		players.add(viratKohli);

		List<Team> teams = new ArrayList<Team>();
		teams.add(teamIndia);

		teamIndia.setPlayers(players);
		viratKohli.setTeams(teams);

		Team savedTeam = service.addTeam(teamIndia);
		assertEquals(13, savedTeam.getTeamId());

	}

	@Test
	public void testGetAllTeams() {
		List<Team> fetchTeam = service.getAllTeams();
		assertEquals(1, fetchTeam.size());
	}

	@Test(expected = TeamNotFoundException.class)
	public void testGetTeamById() throws TeamNotFoundException 
	{
		assertNotNull(service.getTeamById(3));
	}
	
	@Test(expected = TeamNotFoundException.class)
	public void testGetTeamByName() throws TeamNotFoundException 
	{
		assertNotNull(service.getTeambyName("Australia"));
	}

	@Test
	public void testDeleteTeam() throws TeamNotFoundException 
	{
		assertNotNull(service.deleteTeam(14));
	}
	
	@Test
	public void testUpdateTeam() throws TeamNotFoundException 
	{
		Team teamIndia = service.getTeamById(13);
		teamIndia.setFormat(MatchFormat.TESTS);
		service.updateTeams(teamIndia);
	}
	@Test
	public void contextLoads() {
		assertNotNull(service);
	}

	@Test
	public void testValidateCorrectTeamName() {
		assertTrue(service.validateTeamName("India"));
	}

	@Test
	public void testValidateIncorrectTeamName() {
		assertFalse(service.validateTeamName("vjdnfn"));
	}

	@Test
	public void testValidatecorrectRankings() {
		assertTrue(service.validateRankings("8"));
	}

	@Test
	public void testValidateincorrectRankings() {
		assertFalse(service.validateRankings("vjdnfn"));
	}

	@Test
	public void testValidatecorrectLeagueName() {
		assertTrue(service.validateLeagueName("Carribean premiere afd"));
	}

	@Test
	public void testValidateincorrectLeagueName() {
		assertFalse(service.validateLeagueName("20"));
	}
}