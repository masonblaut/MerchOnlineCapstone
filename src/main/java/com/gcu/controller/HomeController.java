package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.model.ProductModel;

import org.slf4j.*;
/**
 * Main Homepage for MerchOnline once logged in. Only accessible with successful SpringSecurity and HTTP Basic Authentication.
 * @author Mason Blaut
 * @version 1.0
 */
@Controller
public class HomeController {

	@Autowired
	ProductBusinessInterface service;
	
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Displays the home view as the central hub for MerchOnline and displays all products in the database by calling getProducts() from the ProductBusinessService.
	 * @param model
	 * @return home.html
	 */
	@RequestMapping("/home")
	public String home(Model model)
	{
		logger.info("Home Page accessed");
		
		//System.out.println("Home CAPTURED");
		List<ProductModel> products = service.getProducts();
		model.addAttribute("products", products);
		return "home";
	}
}
