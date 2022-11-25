package com.pace.soccerteam.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {

	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		return new AuthenticationManager() {
			
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
	}
	
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(null);
	}
	

	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				JdbcDaoImpl jdbcDaoImpl = new JdbcDaoImpl();
				return jdbcDaoImpl.loadUserByUsername(username);
				
			}
		};
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	      return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
	    AuthenticationProvider authProvider = new DaoAuthenticationProvider();
	     
	    ((DaoAuthenticationProvider) authProvider).setUserDetailsService(userDetailsService());
	    ((DaoAuthenticationProvider) authProvider).setPasswordEncoder(passwordEncoder());
	 
	    return authProvider;
	}
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests().antMatchers("/login").permitAll()
    	.antMatchers("/getEmployee").authenticated()
    	.antMatchers("/addEmployee").hasAnyRole("ADMIN")
    	.antMatchers("/hello").authenticated()
    	.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll()
    	.and().logout().permitAll();
    	
    return http.csrf().disable().build();
    }
     
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
         return null;
    }

	
}
