package com.cg.cric24.player_service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.Cric24.Player_Service.entity.Format;
import com.cg.Cric24.Player_Service.entity.Player;
import com.cg.Cric24.Player_Service.entity.RoleType;
import com.cg.Cric24.Player_Service.entity.Team;
import com.cg.Cric24.Player_Service.repo.PlayerDao;
import com.cg.Cric24.Player_Service.service.PlayerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Cric24ApplicationTests {
	
	@Autowired
	private PlayerService service;
	
	
	@Autowired
	private PlayerDao playerDao;
	
	@Test
	public void testAdd() {
		Player player = new Player();
		
		player.setName("Virat Kohli");
		player.setAge(30);
		player.setRating(9.5);
		player.setRuns(11520);
		player.setRoleType(RoleType.BATSMAN);
		
		Player p2 = playerDao.addPlayer(player);
		assertEquals(p2.getName(), "Virat Kohli");
		
	}
	
	

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testValidateCorrectPlayerName() {
		assertTrue(service.validatePlayerName("Virat Kohli"));
	}
	
	@Test
	public void testValidateIncorrectPlayerName() {
		assertFalse(service.validatePlayerName("virat kohli"));
	}
	
	@Test
	public void testValidateCorrectAge() {
		assertTrue(service.validateAge("30"));
	}
	
	@Test
	public void testValidateIncorrectAge() {
		assertFalse(service.validateAge("300"));
	}
	
	@Test
	public void testValidateCorrectNationality() {
		assertTrue(service.validateNationality("Indian"));
	}
	
	@Test
	public void testValidateIncorrectNationality() {
		assertFalse(service.validateNationality("indian"));
	}
	
	@Test
	public void testValidateCorrectWickets() {
		assertTrue(service.validateWickets("5"));
	}
	
	@Test
	public void testValidateIncorrectWickets() {
		assertFalse(service.validateWickets("fdf"));
	}
	
	@Test
	public void testValidateCorrectRuns() {
		assertTrue(service.validateRuns("11520"));
	}
	
	@Test
	public void testValidateIncorrectRuns() {
		assertFalse(service.validateRuns("rgvsf"));
	}
	
	@Test
	public void testRatingCorrectRule() {
		assertTrue(service.validateRating("9.5"));
		}
	
	@Test
	public void testRatingIncorrectRule() {
		assertFalse(service.validateRating("19.5"));
		}
	
	
	

}
