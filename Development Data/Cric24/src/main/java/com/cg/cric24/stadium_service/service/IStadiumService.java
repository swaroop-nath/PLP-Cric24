package com.cg.cric24.stadium_service.service;

import java.util.List;

import com.cg.cric24.stadium_service.entity.StadiumBean;
import com.cg.cric24.stadium_service.exception.StadiumNotFoundException;

import oracle.net.aso.b;

public interface IStadiumService {

	String Stadium_Name_Rule  = "^[A-Z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{3,}$";
	
	String Capacity_Rule = "[0-9]{3,}";
	
	StadiumBean addStadium (StadiumBean stadium);
	
	StadiumBean fetchById(int stadiumId) throws StadiumNotFoundException;
	
	List<StadiumBean> fetchByName(String stadiumName) throws StadiumNotFoundException;
	
	List<StadiumBean> fetchAll() throws StadiumNotFoundException;
	
	StadiumBean updateStadium(StadiumBean stadium);
	
	Boolean deleteStadium(int stadiumId) throws StadiumNotFoundException;
	
	default boolean validateStadiumName(String stadium_name) {
		return stadium_name.matches(Stadium_Name_Rule);
	}
	
	default boolean validateCapacity(String capacity) {
		return capacity.matches(Capacity_Rule);
	}

}