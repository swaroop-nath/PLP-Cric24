package com.cg.cric24.stadium_service.service;

/**
 * This is the interface of service layer
 * @author Shagufta
 *
 */
import java.util.List;

import com.cg.cric24.stadium_service.entity.Stadium;
import com.cg.cric24.stadium_service.exception.NoRegisteredStadiumException;
import com.cg.cric24.stadium_service.exception.StadiumNotFoundException;

import oracle.net.aso.b;

public interface IStadiumService {

	/**
	 * This service is used to add a new stadium details to the application
	 * @param stadium
	 * @return It returns the new match object with all its details.
	 */
	Stadium addStadium (Stadium stadium);
	
	/**
	 * This service displays details of a stadium based on stadium ID
	 * @param stadiumId
	 * @return gets all details of stadiums based on ID
	 * @throws StadiumNotFoundException
	 */
	Stadium fetchById(int stadiumId) throws StadiumNotFoundException;
	
	/**
	 * This service displays details of all stadiums based on stadium name
	 * @param stadiumName
	 * @return gets all details of stadiums based on name
	 * @throws StadiumNotFoundException
	 */
	List<Stadium> fetchByName(String stadiumName) throws StadiumNotFoundException;
	
	/**
	 * This service displays details of all stadiums of a particular country
	 * @param country
	 * @return displays list of all stadiums from given country
	 * @throws NoRegisteredStadiumException
	 */
	List<Stadium> fetchByCountry(String country)throws NoRegisteredStadiumException;
	
	/**
	 * This service is used to list all the stadium details present
	 * @return displays list of all stadiums
	 * @throws StadiumNotFoundException
	 */
	List<Stadium> fetchAll() throws StadiumNotFoundException;
	
	/**
	 * This service is used to update a stadium details to the application
	 * @param stadium
	 * @return returns the updated details of stadium.
	 */
	Stadium updateStadium(Stadium stadium);
	
	/**
	 * This service is used to delete a particular stadium from the application
	 * @param stadium
	 * @return returns boolean true if delete successful else error
	 */
	Boolean deleteStadium(int stadiumId) throws StadiumNotFoundException;


}