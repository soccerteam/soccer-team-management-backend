package com.pace.soccerteam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pace.soccerteam.beans.Statistics;

public interface StatisticsRepository extends JpaRepository<Statistics, Long>{
	
	Statistics findStatisticsById(long id);
	
	Statistics findStatisticsByMatchId(long matchId);

}
