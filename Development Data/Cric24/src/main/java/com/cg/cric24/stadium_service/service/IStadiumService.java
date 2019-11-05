package com.cg.cric24.stadium_service.service;

import java.util.List;

import com.cg.cric24.stadium_service.entity.Stadium;
import com.cg.cric24.stadium_service.exception.NoRegisteredStadiumException;
import com.cg.cric24.stadium_service.exception.StadiumNotFoundException;

import oracle.net.aso.b;

public interface IStadiumService {

	String Stadium_Name_Rule  = "^[A-Z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{3,}$";
	
	String Capacity_Rule = "[0-9]{3,}";
	
	Stadium addStadium (Stadium stadium);
	
	Stadium fetchById(int stadiumId) throws StadiumNotFoundException;
	
	List<Stadium> fetchByName(String stadiumName) throws StadiumNotFoundException;
	
	List<Stadium> fetchByCountry(String country)throws NoRegisteredStadiumException;
	
	List<Stadium> fetchAll() throws StadiumNotFoundException;
	
	Stadium updateStadium(Stadium stadium);
	
	Boolean deleteStadium(int stadiumId) throws StadiumNotFoundException;
	
	default boolean validateStadiumName(String stadium_name) {
		return stadium_name.matches(Stadium_Name_Rule);
	}
	
	default boolean validateCapacity(String capacity) {
		return capacity.matches(Capacity_Rule);
	}

}