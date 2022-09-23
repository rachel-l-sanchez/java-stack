package com.rachelsanchez.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class ExpenseController {
	private TravelServices travelService;
	
	public ExpenseController(TravelServices travelService) {
		this.travelService = travelService;
	}
	@RequestMapping("/")
	public String index(@ModelAttribute("travel") Travel travel) {
		return "index.jsp";
	}
	@RequestMapping("/expense")
	public String addTravel(@ModelAttribute("travel") Travel travel, Model model) {
			List<Travel> travels = travelService.allTravel();
			model.addAttribute("travels", travels);
			return "index.jsp";
	}
	
	@PostMapping("/expense/add")
	public String processTravel(@ModelAttribute("travel") Travel travel, BindingResult result) {
		
		if (result.hasErrors()) {
			return "index.jsp";
		}
		else {
			travelService.createTravel(travel);
			return "redirect:/expense";
		}
	}

	public TravelServices getTravelService() {
		return this.travelService;
	}

	public void setTravelService(TravelServices travelService) {
		this.travelService = travelService;
	}
	
	@GetMapping("/expense/{id}/edit")
	public String editExpense(@PathVariable("id")Long id, Model model) {
		model.addAttribute("travels", travelService.findExpense(id));
		return "edit.jsp";
	}
	
	@PutMapping("expense/{id}")
	public String updateExpense(@Valid @ModelAttribute("travels") Travel travel, BindingResult result, @PathVariable("id") Long id) {
		
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			travelService.updateExpense(travel);
			return "redirect:/expense";
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		travelService.destroy(id);
		return "redirect:/expense";
	}
	
	@GetMapping("/expense/{id}/name")
	public String getExpenseName(@PathVariable("id") Long id, Model model) {
		model.addAttribute("travels", travelService.findExpense(id));
		return "show.jsp";
	}
}
