package com.josh.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.josh.demo.business.MemBusinessServiceInterface;
import com.josh.model.MemModel;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/addMem")
public class AddMemController 
{
	@Autowired
	private MemBusinessServiceInterface ordersService;
	
	@GetMapping("/")
	public String showMem(Model model)
	{
		model.addAttribute("memModel", new MemModel());
		return "addMem";
	}

	@PostMapping("/add")
	public String addMem(MemModel mem, Model model)
	{
		long result = ordersService.addOne(mem);
		if(result > 0){
			model.addAttribute("memModel2", "Model added! " + mem.toString());
		}
		else{
			model.addAttribute("memModel2", "There was an Error adding that mem");
		}
		
		return "addMem";
	}
}
