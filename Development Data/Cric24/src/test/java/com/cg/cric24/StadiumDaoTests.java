package com.cg.cric24;


import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cric24.stadium_service.dao.IStadiumDao;
import com.cg.cric24.stadium_service.dao.StadiumDaoImpl;
import com.cg.cric24.stadium_service.entity.StadiumBean;
import com.cg.cric24.stadium_service.exception.StadiumNotFoundException;
@SpringBootTest
public class StadiumDaoTests {

	@Autowired
	private IStadiumDao dao;
	
	@Before
	public void init() {
		dao = new StadiumDaoImpl();
	}
	
	@Ignore
	@Test
	public void testRetriveAll() throws StadiumNotFoundException {
		List<StadiumBean> stadiums = dao.retrieveAll();
		for (StadiumBean stadium: stadiums)
			System.out.println(stadiums);
	}
	
	@Ignore
	@Test
	public void testAddStadium(){
		StadiumBean newStadium = new StadiumBean();
		newStadium.setStadiumName("Kenen Staium");
		newStadium.setLocation("Straight Mile Road, Bistupur, Jamshedpur");
		newStadium.setCapacity(1700);
		
		System.out.println(dao.create(newStadium));
	}
	
	@Ignore
	@Test
	public void testRetrieveById()throws StadiumNotFoundException{
		
	}
	
}
