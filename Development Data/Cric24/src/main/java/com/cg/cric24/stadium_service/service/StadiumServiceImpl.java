package com.cg.cric24.stadium_service.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cric24.stadium_service.dao.IStadiumDao;
import com.cg.cric24.stadium_service.entity.Stadium;
import com.cg.cric24.stadium_service.exception.NoRegisteredStadiumException;
import com.cg.cric24.stadium_service.exception.StadiumNotFoundException;

@Service
@Transactional(rollbackFor = StadiumNotFoundException.class)
public class StadiumServiceImpl implements IStadiumService {
	
	@Autowired
	private IStadiumDao dao;

	static Logger serviceLogger = Logger.getLogger(StadiumServiceImpl.class);
	
	@Override
	public Stadium addStadium(Stadium stadium) {
		serviceLogger.info("To add a new stadium");
		return dao.create(stadium);
	}

	@Override
	public Stadium fetchById(int stadiumId) throws StadiumNotFoundException {
		serviceLogger.info("To get a stadium by its ID");
		return dao.retrieveById(stadiumId);
	}

	@Override
	public List<Stadium> fetchByName(String stadiumName) throws StadiumNotFoundException {
		serviceLogger.info("To get a stadium by its name");
		return dao.retrieveByName(stadiumName);
	}


	@Override
	public List<Stadium> fetchByCountry(String country) throws NoRegisteredStadiumException {
		serviceLogger.info("To get list of all stadiums by its country");
		return dao.retrieveByCountry(country);
	}
	
	@Override
	public List<Stadium> fetchAll() throws StadiumNotFoundException {
		serviceLogger.info("To dispaly list of all stadiums");
		return dao.retrieveAll();
	}

	@Override
	public Stadium updateStadium(Stadium stadium) {
		serviceLogger.info("updated details of stadium");
		return dao.update(stadium);
	}

	@Override
	public Boolean deleteStadium(int stadiumId) throws StadiumNotFoundException {
		serviceLogger.info("delete stadium");
		return dao.delete(stadiumId);
	}

}

