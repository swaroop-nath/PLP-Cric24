package com.cg.cric24.stadium_service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cric24.stadium_service.entity.Stadium;
import com.cg.cric24.stadium_service.exception.NoRegisteredStadiumException;
import com.cg.cric24.stadium_service.exception.StadiumNotFoundException;

@Repository
public class StadiumDaoImpl implements IStadiumDao {

	@Autowired
	private EntityManager manager;
	
	@Override
	public Stadium create(Stadium stadium) {
		manager.persist(stadium);
		return stadium;
	}

	@Override
	public Stadium retrieveById(int stadiumId) throws StadiumNotFoundException {
		Stadium stadium = manager.find(Stadium.class, stadiumId);
		if(stadium == null)
			throw new StadiumNotFoundException("Stadium with id "+stadiumId+"not found");
		return stadium;
	}

	@Override
	public List<Stadium> retrieveByName(String stadiumName) throws StadiumNotFoundException {
		List<Stadium> stadiums = manager.createNamedQuery("byName").setParameter("name", stadiumName).getResultList();
		if(stadiums.size() == 0)
			throw new StadiumNotFoundException("There are no stadiums of this name "+stadiumName);
		return stadiums;
	}

	@Override
	public List<Stadium> retrieveAll() throws StadiumNotFoundException {
		List<Stadium> stadiums = manager.createNamedQuery("findAll").getResultList();
		if(stadiums.size() == 0) 
			throw new StadiumNotFoundException("Stadium table is empty");
		return stadiums;
	}

	@Override
	public List<Stadium> retrieveByCountry(String country) throws NoRegisteredStadiumException{
		List<Stadium> stadium = manager.createNamedQuery("byCountry").setParameter("country", country).getResultList();
		if(stadium.size() == 0)
			throw new NoRegisteredStadiumException("Stadiums of this country is not present" + country);
		return stadium;
	}
	
	@Override
	public Stadium update(Stadium stadium) {
		manager.merge(stadium);
		return stadium;
	}

	@Override
	public Boolean delete(int stadiumId) throws StadiumNotFoundException {
		Stadium stadium = manager.find(Stadium.class, stadiumId);
		if(stadium == null)
			throw new StadiumNotFoundException("Stadium with id "+stadiumId+" does not exist");
		manager.remove(stadium);
		return true;
	}

	

}
