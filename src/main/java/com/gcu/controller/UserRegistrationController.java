package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gcu.business.UserAccountBusinessInterface;
import com.gcu.business.UserAccountBusinessService;
import com.gcu.model.UserAccountModel;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	@Autowired
	UserAccountBusinessService service;

	@RequestMapping(value = "/", method= RequestMethod.GET)
	public String displayRegistration(Model model)
	{
		//model.addAttribute("title", "Registration Form");
		model.addAttribute("userAccountModel", new UserAccountModel());
		//model.addAttribute("message", "Test Message");
		return "registration";
	}
	
	@PostMapping("/doRegistration")
	public String doRegistration(@Valid UserAccountModel userAccountModel, BindingResult bindingResult, Model model)
	{
		//System.out.println(String.format("Form with Username of %s and Password of %s", user.getUsername(), user.getPassword()));
		model.addAttribute("userAccountModel", userAccountModel);
		if (bindingResult.hasErrors())
		{
			System.out.println("error discovered: " + bindingResult.getAllErrors());
			//model.addAttribute("title", "Registration Form");
			//model.addAttribute("userAccountModel", userAccountModel);
			return "registration";
		}
		else
		{
			if (service.create(userAccountModel))
			{
				System.out.println("ACCOUNT CREATED");
			}
			else
			{
				System.out.println("CREATE ERROR");
				model.addAttribute("message","SQL Error!!!");
				return "registration";
			}
		}
		
		System.out.println("Registration success!!!");
		return "regSuccess";
	}
}
