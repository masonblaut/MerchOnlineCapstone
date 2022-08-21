package com.gcu.business;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gcu.model.UserAccountModel;

/**
 * Interface for User Account Business Operations.
 * @author Mason Blaut
 * @version 1.0
 */
public interface UserAccountBusinessInterface {
	/**
	 * Creates a new UserAccountModel to be added to the database.
	 * @param model UserAccountModel for initialization of service.
	 * @return boolean: true for successful creation and false otherwise.
	 */
	public boolean create(UserAccountModel model);
	/**
	 * Fetches UserDetails by searching for their specific username.
	 * @param username String to search for in the username field.
	 * @return UserDetails to be returned once found.
	 * @throws UsernameNotFoundException Throws Exception if the username cannot be found.
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
