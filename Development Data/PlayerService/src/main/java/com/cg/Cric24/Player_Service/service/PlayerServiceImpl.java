package com.cg.Cric24.Player_Service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.Cric24.Player_Service.entity.Player;
import com.cg.Cric24.Player_Service.exception.PlayerNotfoundException;

@Service
@Transactional(rollbackFor = PlayerNotfoundException.class)
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private com.cg.Cric24.Player_Service.repo.PlayerDao dao;

	@Override
	public Player addPlayer(Player player) {
		return dao.addPlayer(player);
	}

	@Override
	public List<Player> getAllPlayers() {
		return dao.getAllPlayers();
	}

	@Override
	public Player getPlayerById(int id) throws PlayerNotfoundException {
		return dao.getPlayerById(id);
	}

	@Override
	public Player updatePlayer(Player player) {
		return dao.updatePlayer(player);
	}

	@Override
	public boolean deletePlayer(int id) throws PlayerNotfoundException {
		try {
			dao.deletePlayer(id);
			return true;
		} catch (Exception e) {
			throw new PlayerNotfoundException("No player found with current id: " + id);
		}
	}

	@Override
	public List<Player> getPlayer(String name) throws PlayerNotfoundException {
		return dao.getPlayer(name);
	}

}
