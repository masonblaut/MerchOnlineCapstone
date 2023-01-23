package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * The Main Application Page for MerchOnline2
 * @author Mason Blaut
 * @version 2.0
 */
@ComponentScan({"com.gcu"})
@SpringBootApplication
public class MerchOnlineApplication {

	/**
	 * Main Application Run method.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MerchOnlineApplication.class, args);
	}

}
