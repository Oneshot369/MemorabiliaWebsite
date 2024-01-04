package com.josh.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.josh.demo.business.MemBusinessServiceInterface;
import com.josh.model.MemModel;

@Controller
@RequestMapping("/mem")
public class MemController {
	
	@Autowired
	private MemBusinessServiceInterface ordersService;
	
	@GetMapping("/")
	public String showAllOrders(Model model)
	{
		List<MemModel> orders = ordersService.getMem();
		
		model.addAttribute("title", ordersService.getTitle());
		model.addAttribute("mems", orders);
		model.addAttribute("memModel", new MemModel());
		return "mem";
	}

	
	@GetMapping("/{name}")
	public String searchForMem(@RequestParam(name="name", required=false) String name, Model model)
	{
		List<MemModel> orders = ordersService.searchMem(name);
		if(name != "")
		{
			model.addAttribute("title", ordersService.getSearchTitle(name));
			model.addAttribute("mems", orders);
	
			return "mem";
		}
		model.addAttribute("title", ordersService.getTitle());
		model.addAttribute("mems", orders);
		return "mem";
	}

	@PostMapping("/editMem")
	public String editMem(MemModel mem ,Model model){
		model.addAttribute("memModel", mem);
		return "editMem";
	}

	@PostMapping("/delMem")
	public String deleteMem(long id, Model model){
		ordersService.deleteOne(id);
		List<MemModel> orders = ordersService.getMem();
		model.addAttribute("mems", orders);
		model.addAttribute("title", ordersService.getTitle());

		return "mem";
	}

	@PostMapping("/doUpdate")
	public String doUpdate(MemModel mem, Model model){
		ordersService.updateOne(mem);

		List<MemModel> orders = ordersService.getMem();
		model.addAttribute("mems", orders);
		model.addAttribute("title", ordersService.getTitle());
		return "mem";
	}
	
}
