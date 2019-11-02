package com.cg.Cric24.Player_Service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.Cric24.Player_Service.entity.Player;

public interface PlayerRepo extends JpaRepository<Player,Integer> {
	
	@Query("SELECT p FROM Player p WHERE p.name=:nam")
	List<Player> getPlayer(String name);

}
