package com.rachelsanchez.savetravels.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rachelsanchez.savetravels.models.Travel;
import com.rachelsanchez.savetravels.repositories.ExpenseRepository;

@Service
public class TravelServices {
	@Autowired
	private final ExpenseRepository expenseRepository;

	public TravelServices(ExpenseRepository travelRepository) {
		this.expenseRepository = travelRepository;
	}
	
	public List<Travel> allTravel() {
		return this.expenseRepository.findAll();
	}

	public ExpenseRepository getTravelRepository() {
		return expenseRepository;
	}
	
	public Travel createTravel(Travel t) {
		return expenseRepository.save(t);
	}
	
	public String findTravel(Long id) {
	    Optional<Travel> travels = expenseRepository.findById(id);
	      if(travels.isPresent()) {
	    	  return "edit.jsp";
	      }
	      else {
	    	  return "redirect:/";
	      }
	}
	
}
