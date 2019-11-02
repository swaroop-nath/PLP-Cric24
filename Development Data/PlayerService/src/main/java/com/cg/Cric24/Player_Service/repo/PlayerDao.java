package com.cg.Cric24.Player_Service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.Cric24.Player_Service.entity.Player;

public interface PlayerDao extends JpaRepository<Player,Integer> {
	
	

}
