package com.josh.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.ui.Model;

import com.josh.demo.business.SecurityServiceInterface;
import com.josh.model.NewUserModel;

@Controller
@RequestMapping("/newUser")
public class NewUserController 
{
    @Autowired
    SecurityServiceInterface securityService;
    
    @GetMapping("/")
    public String showAllOrders(Model model)
    {
        model.addAttribute("newUserModel", new NewUserModel());
        return "newUser";
    }

    @PostMapping("/add")
    public String addNewUser(NewUserModel nUser, Model model){
        model.addAttribute("newUser2", nUser);
        securityService.addUser(nUser);
        return "newUser";
    }
    
}