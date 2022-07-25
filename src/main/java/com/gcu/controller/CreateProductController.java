package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcu.model.ProductModel;

@Controller
@RequestMapping("/createProduct")
public class CreateProductController {
	
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public String displayCreateProduct(Model model)
	{
		model.addAttribute("title", "New Product:");
		model.addAttribute("productModel", new ProductModel());
		return "createProduct";
	}
	
	@PostMapping("/doCreateProduct")
	public String doLogin(@Valid ProductModel prod, BindingResult bindingResult, Model model)
	{
		
		if (bindingResult.hasErrors())
		{
			System.out.println("error discovered: " + bindingResult.getAllErrors());
			model.addAttribute("title", "Create Product:");
			model.addAttribute("productModel", prod);
			return "createProduct";
		}
		
		System.out.println(String.format("%s , %s , %s , %s , %s", prod.getId(), prod.getProductNo(), prod.getProductName(), prod.getPrice(), prod.getQuantity()));
		
		return "createProduct";
	}
}
