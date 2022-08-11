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

@Controller
public class ProductEditController {
	
	@Autowired
	ProductBusinessInterface service;
	
	@GetMapping(value = "/productEdit")
	public String displayProductEdit(@RequestParam String id, Model model)
	{
		ProductModel prod = service.findProductById(id);
		model.addAttribute("productModel", prod );
		return "productEdit";
	}

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
