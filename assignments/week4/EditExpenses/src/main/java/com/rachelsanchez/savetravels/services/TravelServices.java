package com.rachelsanchez.savetravels.services;

import java.util.List;
import java.util.Optional;
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
	
	public Travel findExpense(Long id) {
	    Optional<Travel> optTravel = expenseRepository.findById(id);
	      if(optTravel.isPresent()) {
	          return optTravel.get();
	      } else {
	          return null;
	      }
	}

	public Travel updateExpense(Travel travel) {
		// TODO Auto-generated method stub
		return expenseRepository.save(travel);
	}

	public void destroy(Long id) {
		// TODO Auto-generated method stub
		expenseRepository.deleteById(id);
	}

	public ExpenseRepository getExpenseRepository() {
		return expenseRepository;
	}

	public void setExpense() {
		// TODO Auto-generated method stub
		
	}
	
}
