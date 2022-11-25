package com.pace.soccerteam.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pace.soccerteam.beans.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String>{
	
	
	
}
