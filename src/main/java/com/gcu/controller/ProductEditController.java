package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.model.ProductModel;

/**
 * Spring Controller for the productEdit view. Utilizes ProductBusinessService via dependency injection
 * to find a ProductModel object from the database and display in in an editable form.
 * @author ROG
 *
 */
@Controller
public class ProductEditController {
	
	@Autowired
	ProductBusinessInterface service;
	/**
	 * Displays the productEdit view by looking for the ProductModel within the database by searching its id String with findProductById() from the ProductBusinessService.
	 * @param id String for findProductById().
	 * @param model
	 * @return productEdit.html
	 */
	@GetMapping(value = "/productEdit")
	public String displayProductEdit(@RequestParam String id, Model model)
	{
		ProductModel prod = service.findProductById(id);
		model.addAttribute("productModel", prod );
		return "productEdit";
	}
	/**
	 * Handles the form submit button, which calles updateProduct() from the ProductBusinessService.
	 * @param prod ProductModel that was found with findProductById(). Users cannot edit the id string of the ProductModel that is being updated.
	 * @param bindingResult BindingResult from the html form.
	 * @param model
	 * @return case 1: productEdit.html if a form input error is discovered, case 2: productView.html if the update was successful, case 3: productEdit.html if there was an update error from ProductBusinessService.
	 */
	@PostMapping("/doProductEdit")
	public String doProductEdit(@Valid ProductModel prod, BindingResult bindingResult, Model model)
	{
		model.addAttribute("productModel", prod);
		System.out.println("Edit Product Id: " + prod.getId());
		
		if (bindingResult.hasErrors())
		{
			System.out.println("Input error discovered: " + bindingResult.getAllErrors());
			return "productEdit";
		}
		
		if (service.updateProduct(prod))
		{
			model.addAttribute("title", "Product Edit Success!");
			return "/productView";
		}
		
		System.out.println("Product Edit Failed!");
		return "productEdit";
	}
}
