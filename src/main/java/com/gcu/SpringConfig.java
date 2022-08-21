package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.business.ProductBusinessService;
import com.gcu.business.UserAccountBusinessInterface;
import com.gcu.business.UserAccountBusinessService;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 * Spring Configuration Class
 * Enables Spring IoC container for Dependency Injection of business services.
 * @author Mason Blaut
 *
 */
@Configuration
public class SpringConfig {

	/**
	 * Injects a ProductBusinessService for instances of Product Business Interface with an Initialization method of "init" and a Destroy method of "destroy".
	 * @return ProductBusinessInterface
	 */
	@Bean(name="productBusinessService", initMethod="init", destroyMethod="destroy")
	public ProductBusinessInterface getProductBusiness()
	{
		return new ProductBusinessService();
	}
	
	/**
	 * Injects a UserAccountBusinessService for the SecurityConfig class.
	 * @return UserAccountBusinessService
	 */
	@Bean(name="userAccountBusinessService")
	public UserAccountBusinessService getUserAccountService()
	{
		return new UserAccountBusinessService();
	}
}
