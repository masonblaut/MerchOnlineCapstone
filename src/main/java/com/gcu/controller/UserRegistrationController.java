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

/**
 * Spring Controller which displays the Registration view and utilizes the UserAccountBusinessService to create new User Account records in the database for authentication.
 * @author Mason Blaut
 * @version 1.0
 */
@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	@Autowired
	UserAccountBusinessService service;

	/**
	 * Displays the Registration view, which includes a form for new user accounts to be submitted.
	 * @param model
	 * @return registration.html
	 */
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public String displayRegistration(Model model)
	{
		//model.addAttribute("title", "Registration Form");
		model.addAttribute("userAccountModel", new UserAccountModel());
		//model.addAttribute("message", "Test Message");
		return "registration";
	}
	/**
	 * Handles the submit button for the registration.html form.
	 * @param userAccountModel the UserAccountModel to be created with create() from the UserAccountBusinessService.
	 * @param bindingResult BindingResult from the registration form.
	 * @param model
	 * @return registration.html upon new account creation error and regSuccess.html upon successful account creation.
	 */
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
