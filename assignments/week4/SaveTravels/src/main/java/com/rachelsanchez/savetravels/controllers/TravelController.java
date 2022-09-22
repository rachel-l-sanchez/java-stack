package com.rachelsanchez.savetravels.controllers;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
