package com.josh.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.josh.demo.business.SecurityServiceInterface;
import com.josh.model.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	SecurityServiceInterface securityService;
	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}

	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		// Create a list of users
		if(securityService.isAuthenticated(loginModel))
		{
			model.addAttribute("loginModel", loginModel);
			return "loginSuccess";
		}
		else
		{
			model.addAttribute("error", "Incorrect Password or Username");
			return "login";
		}
	}
}
