package com.hemlata.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//following api request are to be considered as authorized requests
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/news").permitAll()
		.antMatchers("/byDate").permitAll()
		.antMatchers("/LBG").permitAll()
		.antMatchers("/home").permitAll();
		
	}
}
