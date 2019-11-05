package com.cg.cric24.stadium_service.dao;

import java.util.List;

import com.cg.cric24.stadium_service.entity.Stadium;
import com.cg.cric24.stadium_service.exception.NoRegisteredStadiumException;
import com.cg.cric24.stadium_service.exception.StadiumNotFoundException;

public interface IStadiumDao {

	Stadium create (Stadium stadium);
	
	Stadium retrieveById(int stadiumId) throws StadiumNotFoundException;
	
	List<Stadium> retrieveByName(String stadiumName) throws StadiumNotFoundException;
	
	List<Stadium> retrieveAll() throws StadiumNotFoundException;
	
	List<Stadium> retrieveByCountry(String country)throws NoRegisteredStadiumException;
	
	Stadium update(Stadium stadium);
	
	Boolean delete(int id) throws StadiumNotFoundException;
}
