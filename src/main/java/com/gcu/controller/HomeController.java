package com.gcu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.model.ProductModel;

@Controller
public class HomeController {

	@Autowired
	ProductBusinessInterface service;
	
	@RequestMapping("/home")
	public String home(Model model)
	{
		//System.out.println("Home CAPTURED");
		List<ProductModel> products = service.getProducts();
		model.addAttribute("products", products);
		return "home";
	}
}
