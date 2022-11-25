package com.pace.soccerteam.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pace.soccerteam.beans.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
