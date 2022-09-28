package com.rachelsanchez.dojosandninjas.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rachelsanchez.dojosandninjas.models.Dojo;
import com.rachelsanchez.dojosandninjas.models.Ninja;
import com.rachelsanchez.dojosandninjas.services.DojoService;

@Controller
public class DojosAndNinjasController {
	@Autowired
	private DojoService dojoService;

	@GetMapping("/")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		return "index.jsp";
	}

	
//	form to add a new dojo to the list of options
	@PostMapping("/dojo/create")
	public String createOneDojo(@Valid @ModelAttribute("dojo") Dojo dojo, Model model, BindingResult result){
		if (result.hasErrors()) {
			return "index.jsp";
		}
		else {
			model.addAttribute("dojos", dojoService.createDojo(dojo));
			return "redirect:/ninja";
		}
	}
	
	@GetMapping("/ninja")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model, BindingResult result) {
		model.addAttribute("first_name", ninja);
		model.addAttribute("last_name", ninja);
		model.addAttribute("age", ninja);
		model.addAttribute("dojos", dojoService.allDojosAndNinjas());
		return "ninja.jsp";
	}
	
//	form to create ninjas with appropriate dojos
	@PostMapping("/ninja/create")
	public String createOneNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		
		if (result.hasErrors()) {
			return "ninja.jsp";
		} else {
			dojoService.createNinja(ninja);
			return "redirect:/all/" + ninja.getDojo().getId();
		}
	}
	
//	render all 
	@GetMapping("/all/{id}")
	public String showAllDojosNinjas(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojos(id);
		model.addAttribute("dojo", dojo);
		return "show.jsp";
	}
	
}
