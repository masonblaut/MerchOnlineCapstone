package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.model.ProductModel;

/**
 * Spring Controller for the productView view, which simply displays an individual product's data.
 * @author Mason Blaut
 * @version 1.0
 */
@Controller
public class ProductViewController {

	@Autowired
	ProductBusinessInterface service;
	/**
	 * Displays the productView view after upon a successful call to findProductById() with the ProductBusinessService using the id String parameter.
	 * @param id String used for findProductById()
	 * @param model
	 * @return productView.html
	 */
	@GetMapping(value = "/productView")
	public String displayProductView(@RequestParam String id, Model model)
	{
		ProductModel prod = service.findProductById(id);
		model.addAttribute("productModel", prod );
		return "productView";
	}
	
}
