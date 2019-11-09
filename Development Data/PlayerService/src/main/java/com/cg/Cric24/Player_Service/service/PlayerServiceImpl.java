package com.cg.Cric24.Player_Service.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.Cric24.Player_Service.entity.Player;
import com.cg.Cric24.Player_Service.exception.PlayerNotfoundException;
/**
 * Implementation of player service
 * @author Akash Sarkar
 *
 */
@Service
@Transactional(rollbackFor = PlayerNotfoundException.class)
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private com.cg.Cric24.Player_Service.repo.PlayerDao dao;
	
	static Logger serviceLogger = Logger.getLogger(PlayerServiceImpl.class);

	@Override
	public Player addPlayer(Player player) {
		serviceLogger.info("To add a new player");
		return dao.addPlayer(player);
	}

	@Override
	public List<Player> getAllPlayers() {
		serviceLogger.info("Display list of all players added");
		return dao.getAllPlayers();
	}

	@Override
	public Player getPlayerById(int id) throws PlayerNotfoundException {
		serviceLogger.error("PLayer with given Id not found else search successful");
		return dao.getPlayerById(id);
	}

	@Override
	public Player updatePlayer(Player player) {
		serviceLogger.info("update details of player");
		return dao.updatePlayer(player);
	}

	@Override
	public boolean deletePlayer(int id) throws PlayerNotfoundException {
		serviceLogger.info("delete details of player");
		return dao.deletePlayer(id);
	}

	@Override
	public List<Player> getPlayer(String name) throws PlayerNotfoundException {
		serviceLogger.error("PLayer with given name not found else search successful");
		return dao.getPlayer(name);
	}

}
