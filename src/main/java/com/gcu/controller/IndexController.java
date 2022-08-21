package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Index Page for Merch Online users before logging in and when logging out.
 * @author Mason Blaut
 * @version 1.0
 */
@Controller
public class IndexController {

	/**
	 * Displays initial index page before login.
	 * @param model
	 * @return index.html
	 */
	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("title", "Start Page! Please Login");
		return "index";
	}
	/**
	 * Handles the /logout uri from Spring security.
	 * @param model
	 * @return index.html
	 */
	@GetMapping("/logout")
	public String logoutIndex(Model model)
	{
		model.addAttribute("title", "Start Page! Please Login");
		return "index";
	}
}
