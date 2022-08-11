package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.business.ProductBusinessInterface;
import com.gcu.model.ProductModel;

@Controller
public class ProductViewController {

	@Autowired
	ProductBusinessInterface service;
	
	@GetMapping(value = "/productView")
	public String displayProductView(@RequestParam String id, Model model)
	{
		ProductModel prod = service.findProductById(id);
		model.addAttribute("productModel", prod );
		return "productView";
	}
	
}
