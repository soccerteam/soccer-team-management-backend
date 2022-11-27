package com.pace.soccerteam.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {
	
	@Autowired
	private JwtAuthTokenFilter authJwtTokenFilter;
	
	@Autowired
	private AuthEntryPointExceptionHandler unauthorizedHandler;
	
	
	
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(null);
		
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	      return new BCryptPasswordEncoder();
	}
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests().antMatchers("/api/auth/**").permitAll()
        .antMatchers("/api/test/**").permitAll()
        .anyRequest().authenticated();

      return http.addFilterBefore(authJwtTokenFilter, UsernamePasswordAuthenticationFilter.class).build();
	
      
    }
     
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
         return null;
    }

	
}
