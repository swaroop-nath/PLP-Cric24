package com.cg.cric24.stadium_service.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.cric24.stadium_service.entity.Stadium;
import com.cg.cric24.stadium_service.exception.NoRegisteredStadiumException;
import com.cg.cric24.stadium_service.exception.StadiumNotFoundException;

@Repository
public class StadiumDaoImpl implements IStadiumDao {

	@Autowired
	private EntityManager manager;
	
	static Logger daoLogger = Logger.getLogger(StadiumDaoImpl.class);
	
	@Override
	public Stadium create(Stadium stadium) {
		manager.persist(stadium);
		daoLogger.info("To add a new stadium");
		return stadium;
	}

	@Override
	public Stadium retrieveById(int stadiumId) throws StadiumNotFoundException {
		Stadium stadium = manager.find(Stadium.class, stadiumId);
		if(stadium == null) {
			daoLogger.error("No stadium details found for given ID");
			throw new StadiumNotFoundException("Stadium with id "+ stadiumId + " not found");
		}
		daoLogger.info("search successful");	
		return stadium;
	}

	@Override
	public List<Stadium> retrieveByName(String stadiumName) throws StadiumNotFoundException {
		List<Stadium> stadiums = manager.createNamedQuery("byName").setParameter("name", stadiumName).getResultList();
		if(stadiums.size() == 0) {
			daoLogger.error("No stadium found for the given name");
			throw new StadiumNotFoundException("There are no stadiums of this name "+stadiumName);
		}
		daoLogger.info("search successful");
		return stadiums;
	}

	@Override
	public List<Stadium> retrieveAll() throws StadiumNotFoundException {
		List<Stadium> stadiums = manager.createNamedQuery("findAll").getResultList();
		if(stadiums.size() == 0) {
			daoLogger.error("No stadium details found");
			throw new StadiumNotFoundException("Stadium table is empty");
		}
		daoLogger.info("search successful");
		return stadiums;
	}

	@Override
	public List<Stadium> retrieveByCountry(String country) throws NoRegisteredStadiumException{
		List<Stadium> stadium = manager.createNamedQuery("byCountry").setParameter("country", country).getResultList();
		if(stadium.size() == 0) {
			daoLogger.error("No stadium found for the given country");
			throw new NoRegisteredStadiumException("Stadiums of this country is not present " + country);
		}
		daoLogger.info("search successful");
		return stadium;
	}
	
	@Override
	public Stadium update(Stadium stadium) {
		manager.merge(stadium);
		daoLogger.info("updated details of stadium");
		return stadium;
	}

	@Override
	public Boolean delete(int stadiumId) throws StadiumNotFoundException {
		Stadium stadium = manager.find(Stadium.class, stadiumId);
		if(stadium == null) 
			throw new StadiumNotFoundException("Stadium with id "+stadiumId+" does not exist");
		manager.remove(stadium);
		daoLogger.info("delete stadium");
		return true;
	}

	

}
