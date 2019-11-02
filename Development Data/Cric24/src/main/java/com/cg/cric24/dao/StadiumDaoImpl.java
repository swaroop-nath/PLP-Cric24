package com.cg.cric24.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cric24.entity.StadiumBean;
import com.cg.cric24.exception.StadiumNotFoundException;

@Repository
public class StadiumDaoImpl implements IStadiumDao {

	@Autowired
	private EntityManager manager;
	
	@Override
	public StadiumBean create(StadiumBean stadium) {
		manager.persist(stadium);
		return stadium;
	}

	@Override
	public StadiumBean retrieveById(int stadiumId) throws StadiumNotFoundException {
		StadiumBean stadium = manager.find(StadiumBean.class, stadiumId);
		if(stadium == null)
			throw new StadiumNotFoundException("Stadium with id "+stadiumId+"not found");
		return stadium;
	}

	@Override
	public List<StadiumBean> retrieveByName(String stadiumName) throws StadiumNotFoundException {
		List<StadiumBean> stadiums = manager.createNamedQuery("byName").setParameter("name", stadiumName).getResultList();
		if(stadiums.size() == 0)
			throw new StadiumNotFoundException("There are no stadiums of this name "+stadiumName);
		return stadiums;
	}

	@Override
	public List<StadiumBean> retrieveAll() throws StadiumNotFoundException {
		List<StadiumBean> stadiums = manager.createNamedQuery("findAll").getResultList();
		if(stadiums.size() == 0) 
			throw new StadiumNotFoundException("Stadium table is empty");
		return stadiums;
	}

	@Override
	public StadiumBean update(StadiumBean stadium) {
		manager.merge(stadium);
		return stadium;
	}

	@Override
	public Boolean delete(int stadiumId) throws StadiumNotFoundException {
		StadiumBean stadium = manager.find(StadiumBean.class, stadiumId);
		if(stadium == null)
			throw new StadiumNotFoundException("Stadium with id "+stadiumId+" does not exist");
		manager.remove(stadium);
		return true;
	}

}
