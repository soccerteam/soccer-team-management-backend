package com.pace.soccerteam.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pace.soccerteam.beans.User;

@Repository
public interface UserInfoRepository extends JpaRepository<User, Long>{
	
	
	@Query(
			  value = "SELECT * FROM users u WHERE u.first_name LIKE %:username% OR u.last_name  LIKE %:username% OR  u.username LIKE %:username% OR u.email LIKE %:username%", 
			  nativeQuery = true)

	  List<User> findUserByQueryConatining(String username);
	
	  Optional<User> findByUsername(String username);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
	  


}
