package com.pace.soccerteam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pace.soccerteam.beans.MatchStatistics;

public interface MatchStatisticsRepository extends JpaRepository<MatchStatistics, Long>{
	
	MatchStatistics findMatchStatisticsById(long id);
	
	MatchStatistics findMatchStatisticsByMatchId(long matchId);

}
