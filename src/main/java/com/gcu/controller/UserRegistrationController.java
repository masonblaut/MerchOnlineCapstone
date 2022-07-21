package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcu.model.UserAccountModel;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	@RequestMapping(value = "/", method= RequestMethod.GET)
	public String displayRegistration(Model model)
	{
		//model.addAttribute("title", "Registration Form");
		model.addAttribute("userAccountModel", new UserAccountModel());
		model.addAttribute("message", "Test Message");
		return "registration";
	}
	
	@PostMapping("/doRegistration")
	public String doRegistration(@Valid UserAccountModel userAccountModel, BindingResult bindingResult, Model model)
	{
		//System.out.println(String.format("Form with Username of %s and Password of %s", user.getUsername(), user.getPassword()));
		
		if (bindingResult.hasErrors())
		{
			System.out.println("error discovered: " + bindingResult.getAllErrors());
			//model.addAttribute("title", "Registration Form");
			model.addAttribute("userAccountModel", userAccountModel);
			return "registration";
		}
		
		System.out.println("Registration success!!!");
		return "home";
	}
}
