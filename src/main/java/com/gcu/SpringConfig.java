package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.business.ProductBusinessService;
import com.gcu.business.UserAccountBusinessInterface;
import com.gcu.business.UserAccountBusinessService;



@Configuration
public class SpringConfig {

	@Bean(name="productBusinessService", initMethod="init", destroyMethod="destroy")
	public ProductBusinessInterface getProductBusiness()
	{
		return new ProductBusinessService();
	}
	
	@Bean(name="userAccountBusinessService")
	public UserAccountBusinessInterface getUserAccounts()
	{
		return new UserAccountBusinessService();
	}
	
}
