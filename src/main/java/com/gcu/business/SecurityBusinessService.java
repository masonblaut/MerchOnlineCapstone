package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.UserAccountDataService;
import com.gcu.data.entity.UserAccountEntity;

@Service
public class SecurityBusinessService {
	
	@Autowired
	UserAccountDataService service;
	
	public boolean authenticate(String username, String password)
	{
		List<UserAccountEntity> accounts = service.findAll();
		
		for (UserAccountEntity entity : accounts)
		{
			System.out.println("Security looking at: " + entity.getUsername()+ " " + entity.getPassword());
			if(entity.getUsername().equals(username) && entity.getPassword().equals(password))
			{
				System.out.println("Security found " + entity.getUsername()+ " " + entity.getPassword()+"!");
				return true;
			}
		}
		return false;
	}

}
