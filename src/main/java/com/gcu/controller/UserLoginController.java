package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Spring Controller that returns the login view for Spring Security.
 * @author Mason Blaut
 * @version 1.0
 */
@Controller
public class UserLoginController {
	
	/**
	 * Displays the basic Login Form page
	 * @param model
	 * @return login.html
	 */
	@GetMapping(value = "/login")
	public String displayLogin(Model model)
	{
		model.addAttribute("title", "Login Form");
		return "login";
	}
}
