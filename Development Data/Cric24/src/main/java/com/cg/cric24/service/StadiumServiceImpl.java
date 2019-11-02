package com.cg.cric24.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.cric24.dao.IStadiumDao;
import com.cg.cric24.entity.StadiumBean;
import com.cg.cric24.exception.StadiumNotFoundException;

@Service
@Transactional(rollbackFor = StadiumNotFoundException.class)
public class StadiumServiceImpl implements IStadiumService {
	
	@Autowired
	private IStadiumDao dao;

	@Override
	public StadiumBean addStadium(StadiumBean stadium) {
		return dao.create(stadium);
	}

	@Override
	public StadiumBean fetchById(int stadiumId) throws StadiumNotFoundException {
		return dao.retrieveById(stadiumId);
	}

	@Override
	public List<StadiumBean> fetchByName(String stadiumName) throws StadiumNotFoundException {
		return dao.retrieveByName(stadiumName);
	}

	@Override
	public List<StadiumBean> fetchAll() throws StadiumNotFoundException {
		return dao.retrieveAll();
	}

	@Override
	public StadiumBean updateStadium(StadiumBean stadium) {
		return dao.update(stadium);
	}

	@Override
	public Boolean deleteStadium(int stadiumId) throws StadiumNotFoundException {
		return dao.delete(stadiumId);
	}

}
