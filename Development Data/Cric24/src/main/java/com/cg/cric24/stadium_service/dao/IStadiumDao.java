package com.cg.cric24.stadium_service.dao;

/**
 * This is the interface of dao layer
 * @author Shagufta
 *
 */
import java.util.List;

import com.cg.cric24.stadium_service.entity.Stadium;
import com.cg.cric24.stadium_service.exception.NoRegisteredStadiumException;
import com.cg.cric24.stadium_service.exception.StadiumNotFoundException;

public interface IStadiumDao {

	/**
	 * This method is used to add a new stadium details to the application
	 * @param stadium
	 * @return It returns the new match object with all its details.
	 */
	Stadium create(Stadium stadium);
	
	/**
	 * This method displays details of a stadium based on stadium ID
	 * @param stadiumId
	 * @return gets all details of stadiums based on ID
	 * @throws StadiumNotFoundException
	 */
	Stadium retrieveById(int stadiumId) throws StadiumNotFoundException;
	
	/**
	 * This method displays details of all stadiums based on stadium name
	 * @param stadiumName
	 * @return gets all details of stadiums based on name
	 * @throws StadiumNotFoundException
	 */
	List<Stadium> retrieveByName(String stadiumName) throws StadiumNotFoundException;
	
	/**
	 * This method is used to list all the stadium details present
	 * @return displays list of all stadiums
	 * @throws StadiumNotFoundException
	 */
	List<Stadium> retrieveAll() throws StadiumNotFoundException;
	
	/**
	 * This method displays details of all stadiums of a particular country
	 * @param country
	 * @return displays list of all stadiums from given country
	 * @throws NoRegisteredStadiumException
	 */
	List<Stadium> retrieveByCountry(String country)throws NoRegisteredStadiumException;
	
	/**
	 * This method is used to update a stadium details to the application
	 * @param stadium
	 * @return returns the updated details of stadium.
	 */
	Stadium update(Stadium stadium);
	
	/**
	 * This method is used to delete a particular stadium from the application
	 * @param stadium
	 * @return returns boolean true if delete successful else error
	 */
	Boolean delete(int id) throws StadiumNotFoundException;
}
