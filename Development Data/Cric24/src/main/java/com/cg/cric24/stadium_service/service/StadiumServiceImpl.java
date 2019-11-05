package com.cg.cric24.stadium_service.service;

import java.util.List;

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

	@Override
	public Stadium addStadium(Stadium stadium) {
		return dao.create(stadium);
	}

	@Override
	public Stadium fetchById(int stadiumId) throws StadiumNotFoundException {
		return dao.retrieveById(stadiumId);
	}

	@Override
	public List<Stadium> fetchByName(String stadiumName) throws StadiumNotFoundException {
		return dao.retrieveByName(stadiumName);
	}


	@Override
	public List<Stadium> fetchByCountry(String country) throws NoRegisteredStadiumException {
		return dao.retrieveByCountry(country);
	}
	
	@Override
	public List<Stadium> fetchAll() throws StadiumNotFoundException {
		return dao.retrieveAll();
	}

	@Override
	public Stadium updateStadium(Stadium stadium) {
		return dao.update(stadium);
	}

	@Override
	public Boolean deleteStadium(int stadiumId) throws StadiumNotFoundException {
		return dao.delete(stadiumId);
	}

}

