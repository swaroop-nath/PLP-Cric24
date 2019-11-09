package com.cg.cric24.player_service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.Cric24.Player_Service.entity.MatchFormat;
import com.cg.Cric24.Player_Service.entity.Player;
import com.cg.Cric24.Player_Service.entity.RoleType;
import com.cg.Cric24.Player_Service.entity.Team;
import com.cg.Cric24.Player_Service.exception.PlayerNotfoundException;
import com.cg.Cric24.Player_Service.repo.PlayerDao;
import com.cg.Cric24.Player_Service.service.PlayerService;
import com.cg.Cric24.Player_Service.web.PlayerController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Cric24ApplicationTests {
	
	@Autowired
	private PlayerService service;
	
	@Autowired
	private PlayerController controller;
	
	@Autowired
	private PlayerDao playerDao;
	
	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}
	
	@Test
	public void testAdd() {
		
		Team teamIndia = new Team();

		teamIndia.setTeamId(1);
		teamIndia.setTeamName("India");
		teamIndia.setRanking(2);
		teamIndia.setFormat(MatchFormat.ODI);
		teamIndia.setLeagues("INTL");
		
		Player viratKohli = new Player();
		
		viratKohli.setName("Virat Kohli");
		viratKohli.setAge(30);
		viratKohli.setRating(933);
		viratKohli.setNationality("Indian");
		viratKohli.setRuns(11520);
		viratKohli.setRoleType(RoleType.BATSMAN);
		viratKohli.setWickets(0);
		
		List<Player> players = new ArrayList<Player>();
		players.add(viratKohli);
		
		List<Team> teams = new ArrayList<Team>();
		teams.add(teamIndia);

		teamIndia.setPlayers(players);
		viratKohli.setTeams(teams);
		
		Player savedPlayer = service.addPlayer(viratKohli);
		assertEquals(1026, savedPlayer.getPlayerId());
		
	}
	
	@Test
	public void testGetAllPlayers(){
		List<Player> fetchPlayers = service.getAllPlayers();
		assertEquals(1, fetchPlayers.size());
	}
	
	@Test
	public void testGetPlayerByName() throws PlayerNotfoundException {
		assertNotNull(service.getPlayer("Virat Kohli"));
	}
	
	@Test(expected = PlayerNotfoundException.class)
	public void testGetPlayerById() throws PlayerNotfoundException {
		assertNotNull(service.getPlayerById(1000));
	}
	
	@Test
	public void testDeletePlayer() throws PlayerNotfoundException{
		assertNotNull(service.deletePlayer(1026));
	}
	
	@Test
	public void testUpdatePlayer() throws PlayerNotfoundException {
		Player viratKohli =service.getPlayerById(1027);
		viratKohli.setRuns(12000);
		service.updatePlayer(viratKohli);
	}
	
		

}
