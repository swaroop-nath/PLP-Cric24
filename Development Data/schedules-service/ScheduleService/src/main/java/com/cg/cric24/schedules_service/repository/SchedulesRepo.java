package com.cg.cric24.schedules_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cric24.schedules_service.entity.Match;

@Repository
public interface SchedulesRepo extends JpaRepository<Match, Integer> {

}