package com.cg.Cric24.Player_Service.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.Cric24.Player_Service.entity.Player;
import com.cg.Cric24.Player_Service.exception.PlayerNotfoundException;
/**
 * Implemetation of the player DAO 
 * @author Akash Sarkar
 *
 */
@Repository
public class PlayerDaoImpl implements PlayerDao {

	@Autowired
	private EntityManager entitymanager;
	
	static Logger daoLogger = Logger.getLogger(PlayerDaoImpl.class);

	@Override
	public Player addPlayer(Player player) {
		Player savedPlayer = entitymanager.merge(player);
		entitymanager.flush();
		daoLogger.info("To add a new player");
		return savedPlayer;
	}

	@Override
	public List<Player> getAllPlayers() {
		daoLogger.info("Display list of all players added");
		return entitymanager.createNamedQuery("allPlayers").getResultList();
	}

	@Override
	public Player getPlayerById(int id) throws PlayerNotfoundException {
		Player p = entitymanager.find(Player.class, id);
		if (p == null) {
			daoLogger.error("PLayer with given Id not found");
			throw new PlayerNotfoundException("Player not found found with id: " + id);
		}
		daoLogger.info("search successful");
		return p;
	}

	@Override
	public List<Player> getPlayer(String name) throws PlayerNotfoundException {
		List<Player> player =  (List<Player>) entitymanager.createNamedQuery("byName").setParameter("nam", name).getResultList();
		if(player.size()==0) {
			daoLogger.error("PLayer with given name not found");
			throw new PlayerNotfoundException("Player not found with name :" + name);
		}
		daoLogger.info("search successful");
		return player;
	}

	@Override
	public Player updatePlayer(Player player) {
		entitymanager.merge(player);
		entitymanager.flush();
		daoLogger.info("updated details of player");
		return player;
	}

	@Override
	public boolean deletePlayer(int id) throws PlayerNotfoundException {
		Player p = entitymanager.find(Player.class, id);
		if (p == null) {
			daoLogger.error("PLayer with given id not found");
			throw new PlayerNotfoundException("Player not found found with id: " + id);
		}
		entitymanager.remove(p);
		System.out.println("Deleted");
		daoLogger.info("delete successful");
		return true;
	}

}
