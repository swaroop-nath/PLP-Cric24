package com.cg.cric24.service;

import java.util.List;

import com.cg.cric24.entity.StadiumBean;
import com.cg.cric24.exception.StadiumNotFoundException;

public interface IStadiumService {

	StadiumBean addStadium (StadiumBean stadium);
	
	StadiumBean fetchById(int stadiumId) throws StadiumNotFoundException;
	
	List<StadiumBean> fetchByName(String stadiumName) throws StadiumNotFoundException;
	
	List<StadiumBean> fetchAll() throws StadiumNotFoundException;
	
	StadiumBean updateStadium(StadiumBean stadium);
	
	Boolean deleteStadium(int stadiumId) throws StadiumNotFoundException;

}