package com.pace.soccerteam.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pace.soccerteam.beans.Lineup;

@Repository
@Transactional
public interface LineupRepository extends JpaRepository<Lineup, Long>{
	
	Lineup findLineupById(Long id);

}
