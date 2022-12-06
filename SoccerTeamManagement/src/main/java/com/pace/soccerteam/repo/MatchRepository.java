package com.pace.soccerteam.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pace.soccerteam.beans.Match;

@Repository
@Transactional
public interface MatchRepository extends JpaRepository<Match, Long> {
	
	 Optional<Match> findById(Long id);

	 boolean existsById(Long id);

}
