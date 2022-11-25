package com.pace.soccerteam.database;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pace.soccerteam.beans.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	 Optional<Users> findByUsername(String username);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
}
