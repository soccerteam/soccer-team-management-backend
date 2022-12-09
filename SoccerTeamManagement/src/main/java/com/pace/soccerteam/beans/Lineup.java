package com.pace.soccerteam.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lineup")
public class Lineup {
	
	
	
	public Lineup(long id, Set<User> users, Set<Match> match) {
		super();
		this.id = id;
		this.users = users;
		this.match = match;
	}
	
	public Lineup() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "lineup")
	private Set<User> users = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "lineup", fetch = FetchType.LAZY)
	private Set<Match> match = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Match> getMatch() {
		return match;
	}

	public void setMatch(Set<Match> match) {
		this.match = match;
	}
	
	

	

	

	
	

}
