package com.pace.soccerteam.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pace.soccerteam.beans.User;


public class UserDetailsImpl implements UserDetails {
	
	
	  private static final long serialVersionUID = 1L;

	  private Long id;

	  private String username;
	  
	  private String email;

	  private String firstName;
	  
	  private String lastName;
	  
	  private boolean verified;

	  
	  @JsonIgnore
	  private String password;

	  private Collection<? extends GrantedAuthority> authorities;

		public UserDetailsImpl(Long id, String username, String email, String password, String firstName,
				String lastName, boolean verified,	Collection<? extends GrantedAuthority> authorities) {
	    this.id = id;
	    this.email= email;
	    this.username = username;
	    this.password = password;
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.authorities = authorities;
	    this.verified = verified;
	  }

	  public static UserDetailsImpl build(User user) {
	    List<GrantedAuthority> authorities = user.getRoles().stream()
	        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
	        .collect(Collectors.toList());

	    return new UserDetailsImpl(
	        user.getId(), 
	        user.getUsername(), 
	        user.getEmail(),
	        user.getPassword(),
	        user.getFirstName(),
	        user.getLastName(),
	        user.isVerified(),
	        authorities);
	  }
	  
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getEmail() {
		return email;
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	
	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	@Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (o == null || getClass() != o.getClass())
	      return false;
	    UserDetailsImpl user = (UserDetailsImpl) o;
	    return Objects.equals(id, user.id);
	  }

}
