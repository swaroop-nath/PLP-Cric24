package com.cg.cric24;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doAnswer;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cric24.stadium_service.dao.IStadiumDao;
import com.cg.cric24.stadium_service.dao.StadiumDaoImpl;
import com.cg.cric24.stadium_service.exception.StadiumNotFoundException;
import com.cg.cric24.stadium_service.service.IStadiumService;
import com.cg.cric24.stadium_service.service.StadiumServiceImpl;

@SpringBootTest
public class StadiumValidationTests {

	@Autowired
	private IStadiumService service;

	@Before
	public void init() {
		service = new StadiumServiceImpl();
	}

	@Ignore
	@Test
	public void testvalidateStadiumName(){
		assertTrue(service.validateStadiumName("Wankhede Stadium"));
	}
	
	@Ignore
	@Test
	public void testInvalidStadiumName() {
		assertFalse(service.validateStadiumName("the Lords"));
		assertFalse(service.validateStadiumName("123 Stadium"));
	}
	
	@Ignore
	@Test
	public void testValidateCapacity() {
		assertTrue(service.validateCapacity("2000"));
	}
	
	@Ignore
	@Test
	public void testInvalidCapacity() {
		assertFalse(service.validateCapacity("10"));
		assertFalse(service.validateCapacity("three"));
	}
	
	@After
	public void tearDown() {
		service = null;
	}
}
