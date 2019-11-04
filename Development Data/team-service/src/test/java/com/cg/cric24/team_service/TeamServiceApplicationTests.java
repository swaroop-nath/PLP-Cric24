package com.cg.cric24.team_service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.cric24.team_service.entity.Format;
import com.cg.cric24.team_service.entity.Player;
import com.cg.cric24.team_service.entity.RoleType;
import com.cg.cric24.team_service.entity.Team;
import com.cg.cric24.team_service.repo.TeamRepo;
import com.cg.cric24.team_service.service.TeamService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamServiceApplicationTests {

	@Autowired
	private TeamService service;
	@Autowired
	private TeamRepo repo;

	@Test
	public void testadd() {
		Team team = new Team();
		team.setTeamName("India");
		team.setRanking(9);
		team.setFormat(Format.ODI);
		team.setLeagues("IPL");
		Player teamPlayer = new Player();
		teamPlayer.setName("Virat Kohli");
		teamPlayer.setAge(30);
		teamPlayer.setNationality("Indian");
		teamPlayer.setRating(8);
		teamPlayer.setRuns(2000);
		teamPlayer.setWickets(10);
		teamPlayer.setRoleType(RoleType.BATSMAN);



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