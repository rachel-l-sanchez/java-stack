package com.rachelsanchez.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rachelsanchez.savetravels.models.Travel;
import com.rachelsanchez.savetravels.services.TravelServices;

@SpringBootApplication
@Controller
public class TravelController {
	private TravelServices travelService;
	
	public TravelController(TravelServices travelService) {
		this.travelService = travelService;
	}
	@RequestMapping("/")
	public String index(@ModelAttribute("travel") Travel travel) {
		return "index.jsp";
	}
	@RequestMapping("/travel")
	public String addTravel(@ModelAttribute("travel") Travel travel, Model model) {
			List<Travel> travels = travelService.allTravel();
			model.addAttribute("travels", travels);
			return "index.jsp";
	}
	
	@PostMapping("/travel/add")
	public String processTravel(@ModelAttribute("travel") Travel travel, BindingResult result) {
		
		if (result.hasErrors()) {
			return "index.jsp";
		}
		else {
			travelService.createTravel(travel);
			return "redirect:/travel";
		}
	}
	
	@GetMapping("travel/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Travel travel = travelService.findTravel(id);
		model.addAttribute("oneTravel", travel);
		return "edit.jsp";
	}
	
	@PutMapping("/travel/{id}")
	public String updateExpense(@Valid @ModelAttribute("travel") Long id, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			travelService.findTravel(id);
			return "redirect:/travel";
		}
	}

	public TravelServices getTravelService() {
		return this.travelService;
	}

	public void setTravelService(TravelServices travelService) {
		this.travelService = travelService;
	}
	
	private static Travel save(Travel t) {
		// TODO Auto-generated method stub
		return t;
	}
}
