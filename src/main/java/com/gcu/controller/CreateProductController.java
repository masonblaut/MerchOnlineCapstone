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

@Controller
@RequestMapping("/createProduct")
public class CreateProductController {
	
	@Autowired
	ProductBusinessInterface service;
	
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public String displayCreateProduct(Model model)
	{
		model.addAttribute("title", "New Product:");
		model.addAttribute("productModel", new ProductModel());
		return "createProduct";
	}
	
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
