package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.model.ProductModel;
/**
 * Spring Controller for productDelete view. Utilizes the ProductBusinessService via dependency injection for product deletion from the database.
 * @author Mason Blaut
 * @version 1.0
 */
@Controller
public class ProductDeleteController {
	
	@Autowired
	ProductBusinessInterface service;
	
	/**
	 * Displays the productDelete page and redirects the user to the homepage after calling deleteProduct() from the ProductBusinessService.
	 * @param id String used for findByProductId().
	 * @param model
	 * @return home.html with a ModelAndView redirect.
	 */
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
