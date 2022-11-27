package com.pace.soccerteam.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pace.soccerteam.beans.ERole;
import com.pace.soccerteam.beans.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Optional<Role> findByName(ERole name);

}
