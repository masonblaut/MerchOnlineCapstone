package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gcu.data.UserAccountDataService;
import com.gcu.data.entity.UserAccountEntity;
import com.gcu.model.UserAccountModel;

/**
 * User Account Business level Service that Implements UserDetailService.
 * @author Mason Blaut
 * @version 1.0
 */
public class UserAccountBusinessService implements UserDetailsService {

	@Autowired
	UserAccountDataService service;
	
	/**
	 * Creates a new UserAccountModel to be added to the database by calling create() from the UserAccountDataService.
	 * @param model UserAccountModel to be added to the database.
	 * @return boolean: true for successful creation and false if the UserAccountDataService cannot be created.
	 */
	public boolean create(UserAccountModel model) {
		String encoded = new BCryptPasswordEncoder().encode(model.getPassword());
		System.out.println(encoded);
		UserAccountEntity entity = new UserAccountEntity(model.getIdNumber(), model.getUserFirstName(), model.getUserLastName(), model.getUserEmail(), model.getUsername(),encoded, model.getUserPhoneNum(), model.getUserAddress1(), model.getUserAddress2(), model.getUserCity(), model.getUserState(), model.getUserZip());
	
		if (service.create(entity))
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
	/**
	 * Creates and Returns a UserDetails object with information gained by calling findByUsername() from the UserAccountDataService with the username String parameter.
	 * @param username String to be searched by the UserAccountDataService findByUsername() method.
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		UserAccountEntity user = service.findByUsername(username);
		if (user != null)
		{
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			String encoded = new BCryptPasswordEncoder().encode(username);
			System.out.println(encoded);
			System.out.println("Username: " + user.getUsername() + " Password: " + user.getPassword());
			
			return new User(user.getUsername(), user.getPassword(), authorities);
		}
		else
		{
			throw new UsernameNotFoundException("username not found");
		}
	}
}
