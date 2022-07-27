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
import com.gcu.business.SecurityBusinessService;
import com.gcu.model.User;

@Controller
@RequestMapping("/login")
public class UserLoginController {
	
	@Autowired
	ProductBusinessInterface service;
	
	@Autowired
	SecurityBusinessService security;
	
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public String displayLogin(Model model)
	{
		model.addAttribute("title", "Login Form");
		model.addAttribute("user", new User());
		model.addAttribute("message", "Test Message");
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid User user, BindingResult bindingResult, Model model)
	{
		
		System.out.println("Attempting login of Username: " + user.getUsername() + "  Password: " + user.getPassword());
		
		if (bindingResult.hasErrors())
		{
			System.out.println("error discovered: " + bindingResult.getAllErrors());
			model.addAttribute("title", "Login Form");
			model.addAttribute("user", user);
			return "login";
		}
		else if (security.authenticate(user.getUsername(), user.getPassword()))
		{
				model.addAttribute("products", service.getProducts());
				return "home";
		}
		
		model.addAttribute("title", "Not Authenticated! Try again:");
		return "login";
	}
}
