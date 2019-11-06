package com.cg.cric24.stadium_service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.cric24.stadium_service.dao.IStadiumDao;
import com.cg.cric24.stadium_service.dao.StadiumDaoImpl;
import com.cg.cric24.stadium_service.entity.Stadium;
import com.cg.cric24.stadium_service.exception.NoRegisteredStadiumException;
import com.cg.cric24.stadium_service.exception.StadiumNotFoundException;
import com.cg.cric24.stadium_service.service.IStadiumService;
import com.cg.cric24.stadium_service.service.StadiumServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StadiumServiceImplTest {
	
	@Autowired
	private IStadiumService service;
	
	@Ignore
	@Test
	public void contextLoads() {
		assertNotNull(service);
	}
	
	@Ignore
	@Test
	public void testAddStadium(){
		Stadium oneStadium = new Stadium();
		oneStadium.setStadiumName("Feroz Shah Kotla");
		oneStadium.setLocation("Raj Ghat, New Delhi");
		oneStadium.setCapacity(41820);
		oneStadium.setStadiumImage("https://s.ndtvimg.com//images/entities/300/feroz-shah-kotla-delhi_636889815309845065.jpg");
		
		List<Stadium> std = new ArrayList<Stadium>();
		std.add(oneStadium);
		System.out.println(service.addStadium(oneStadium));
	}
	
	@Ignore
	@Test
	public void testFetchAll() throws StadiumNotFoundException{
		List<Stadium> fetchStadiums = service.fetchAll();
		assertEquals(4, fetchStadiums.size());
	}
	
	@Ignore
	@Test
	public void testFetchById()throws StadiumNotFoundException{
		assertNotNull(service.fetchById(3));
	}
	
	@Ignore
	@Test(expected = StadiumNotFoundException.class)
	public void testFetchByIncorrectId()throws StadiumNotFoundException{
		assertNotNull(service.fetchById(5));
	}
	
	@Ignore
	@Test
	public void testFetchByCountry()throws NoRegisteredStadiumException{
		List<Stadium> fetchStadiums = service.fetchByCountry("India");
		assertNotNull(fetchStadiums);
	}
	
	@Ignore
	@Test(expected = NoRegisteredStadiumException.class)
	public void testFetchByIncorrectCountry()throws NoRegisteredStadiumException{
		List<Stadium> fetchStadiums = service.fetchByCountry("United States");
		assertNotNull(fetchStadiums);
	}
	
	
	@Ignore
	@Test
	public void testFetchByName()throws StadiumNotFoundException{
		List<Stadium> fetchStadiums = service.fetchByName("Wankhede Stadium");
		assertNotNull(fetchStadiums);
	}
	
	@Ignore
	@Test(expected = StadiumNotFoundException.class)
	public void testFetchByIncorrectName()throws StadiumNotFoundException{
		List<Stadium> fetchStadiums = service.fetchByName("The Lords");
		assertNotNull(fetchStadiums);
	}
	
	
	@Ignore
	@Test
	public void testUpdateStadium() throws StadiumNotFoundException {
			List<Stadium> update = service.fetchAll();
			Stadium stadiumOne = update.get(1);
			
			stadiumOne.setCapacity(1800);
			service.updateStadium(stadiumOne);
		}
	
	@Ignore
	@Test
	public void testDeleteStadium()throws StadiumNotFoundException{
		List<Stadium> delete = service.fetchAll();
		
		service.deleteStadium(2);
	}
	
}
