package com.pace.soccerteam.repo;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pace.soccerteam.beans.Lineup;

@Repository
@Transactional
public interface LineupRepository extends JpaRepository<Lineup, Long>{
	
	Lineup findLineupById(Long id);
	
	List<Lineup> findAll();

}
