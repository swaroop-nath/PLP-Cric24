package com.cg.Cric24.Player_Service.repo;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.Cric24.Player_Service.entity.Player;
import com.cg.Cric24.Player_Service.exception.PlayerNotfoundException;

@Repository
public class PlayerDaoImpl implements PlayerDao {

	@Autowired
	private EntityManager entitymanager;

	@Override
	public Player addPlayer(Player player) {
		entitymanager.persist(player);
		return player;
	}

	@Override
	public List<Player> getAllPlayers() {
		return entitymanager.createNamedQuery("allPlayers").getResultList();
	}

	@Override
	public Player getPlayerById(int id) throws PlayerNotfoundException {
		Player p = entitymanager.find(Player.class, id);
		if (p == null) {
			throw new PlayerNotfoundException("Player not founbd found with id: " + id);
		}
		return p;
	}

	@Override
	public List<Player> getPlayer(String name) throws PlayerNotfoundException {
		List<Player> player =  (List<Player>) entitymanager.createNamedQuery("byName").setParameter("nam", name).getResultList();
		if(player.size()==0) {
			throw new PlayerNotfoundException("Player not found with name :" + name);
		}
		return player;
	}

	@Override
	public Player updatePlayer(Player player) {
		entitymanager.merge(player);
		return player;
	}

	@Override
	public boolean deletePlayer(int id) throws PlayerNotfoundException {
		Player p = entitymanager.find(Player.class, id);
		if (p == null) {
			throw new PlayerNotfoundException("Player not founbd found with id: " + id);
		}
		entitymanager.remove(p);
		return true;
	}

}
