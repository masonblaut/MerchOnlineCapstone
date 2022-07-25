package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.business.ProductsBusinessInterface;
import com.gcu.business.ProductsBusinessService;



@Configuration
public class SpringConfig {

	@Bean(name="productsBusinessService", initMethod="init", destroyMethod="destroy")
	public ProductsBusinessInterface getProductsBusiness()
	{
		return new ProductsBusinessService();
	}
}
