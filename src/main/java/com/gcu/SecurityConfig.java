package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gcu.business.UserAccountBusinessInterface;
import com.gcu.business.UserAccountBusinessService;
import com.gcu.data.entity.UserAccountEntity;

/**
 * Security Configuration Class for MerchOnline2
 * @author Mason Blaut
 * @version 2.0
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Lazy
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserAccountBusinessService service;
	
	/**
	 * setPassword Encoder
	 * @return BCCryptPasswordEncoder
	 */
	@Bean
	BCryptPasswordEncoder setPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * Overrides configure for basic HTTP Authentication.
	 * Security configuration protects web page and API access.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable().httpBasic()
			.and()
			.authorizeRequests()
				.antMatchers("/service/**").permitAll()
				.and()
			.authorizeRequests()
				.antMatchers("/", "/registration", "/registration/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
				.defaultSuccessUrl("/home", true)
				.and()
			.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.permitAll()
				.logoutSuccessUrl("/");
	}
	
	/**
	 * Overrides configure to utilize WebSecurityManagerBuilder for password authentication and verification.
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
			.userDetailsService(service)
			.passwordEncoder(passwordEncoder);
	}
}
