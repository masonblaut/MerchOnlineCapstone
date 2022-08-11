package com.gcu.business;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gcu.model.UserAccountModel;

public interface UserAccountBusinessInterface {
	
	public boolean create(UserAccountModel model);

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
