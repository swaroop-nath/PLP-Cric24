package com.cg.Cric24.Player_Service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.Cric24.Player_Service.entity.Player;
import com.cg.Cric24.Player_Service.exception.PlayerNotfoundException;
import com.cg.Cric24.Player_Service.repo.PlayerRepo;

@Service
@Transactional(rollbackFor = PlayerNotfoundException.class)
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepo repo;

	@Override
	public Player addPlayer(Player player) {
		return repo.save(player);
	}

	@Override
	public List<Player> getAllPlayers() {
		return repo.findAll();
	}

	@Override
	public Player getPlayerById(int id) throws PlayerNotfoundException {
		return repo.findById(id).get();
	}

	@Override
	public Player updatePlayer(Player player) {
		return repo.save(player);
	}

	@Override
	public boolean deletePlayer(int id) throws PlayerNotfoundException {
		try {
			repo.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new PlayerNotfoundException("No player found with current id: " + id);
		}
	}

	@Override
	public List<Player> getPlayer(String name) throws PlayerNotfoundException {
		return repo.getPlayer(name);
	}

}
