package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.model.ProductModel;

@Controller
public class ProductDeleteController {
	
	@Autowired
	ProductBusinessInterface service;
	
	@GetMapping("/productDelete")
	public ModelAndView deleteProduct(@RequestParam String id, Model model)
	{
		ProductModel prod = service.findProductById(id);
		
		if (service.deleteProduct(prod))
			return new ModelAndView("redirect:/home/");
		else
			System.out.println("Product "+ id + " " + prod.getProductName() + " couldn't be deleted.");
			return new ModelAndView("redirect:/home/");
	}
}
