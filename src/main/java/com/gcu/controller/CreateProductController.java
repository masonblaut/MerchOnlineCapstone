package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.model.ProductModel;

/**
 * Spring Controller for the createProduct view. Utilizes the ProductBusinessService via dependency injection to add new form products to the database.
 * @author Mason Blaut
 * @version 1.0
 */
@Controller
@RequestMapping("/createProduct")
public class CreateProductController {
	
	@Autowired
	ProductBusinessInterface service;
	
	/**
	 * Displays the createProduct view, which houses a form for new ProductModel input.
	 * @param model
	 * @return createProduct.html template
	 */
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public String displayCreateProduct(Model model)
	{
		model.addAttribute("title", "New Product:");
		model.addAttribute("productModel", new ProductModel());
		return "createProduct";
	}
	
	/**
	 * Handles the ProductModel creation process and returns the productView view upon successful completion.
	 * @param prod ProductModel object to be created by calling the create() method from the ProductBusinessService.
	 * @param bindingResult BindingResult object received from the form input.
	 * @param model
	 * @return createProduct.html will be returned upon create() failure and productView will be returned upon successful ProductModel creation.
	 */
	@PostMapping("/doCreateProduct")
	public String doCreateProduct(@Valid ProductModel prod, BindingResult bindingResult, Model model)
	{
		model.addAttribute("productModel", prod);
		
		if (bindingResult.hasErrors())
		{
			System.out.println("error discovered: " + bindingResult.getAllErrors());
			model.addAttribute("title", "Create Product:");
			return "createProduct";
		}
		
		service.create(prod);
		
		return "createProdSuccess";
	}
}
