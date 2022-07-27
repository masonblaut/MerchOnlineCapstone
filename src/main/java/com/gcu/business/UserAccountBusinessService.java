package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.UserAccountDataService;
import com.gcu.data.entity.UserAccountEntity;
import com.gcu.model.UserAccountModel;

public class UserAccountBusinessService implements UserAccountBusinessInterface {

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

	
		
	
}
