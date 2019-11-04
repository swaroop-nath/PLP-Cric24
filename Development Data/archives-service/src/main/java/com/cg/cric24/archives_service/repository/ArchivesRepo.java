package com.cg.cric24.archives_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cric24.archives_service.entity.Match;

@Repository
public interface ArchivesRepo extends JpaRepository<Match, Integer> {

}
