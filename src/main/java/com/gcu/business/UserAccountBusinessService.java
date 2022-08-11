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

public class UserAccountBusinessService implements UserDetailsService {

	@Autowired
	UserAccountDataService service;
	
	public boolean create(UserAccountModel model) {
		UserAccountEntity entity = new UserAccountEntity(model.getIdNumber(), model.getUserFirstName(), model.getUserLastName(), model.getUserEmail(), model.getUsername(),model.getPassword(), model.getUserPhoneNum(), model.getUserAddress1(), model.getUserAddress2(), model.getUserCity(), model.getUserState(), model.getUserZip());
	
		if (service.create(entity))
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}

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
