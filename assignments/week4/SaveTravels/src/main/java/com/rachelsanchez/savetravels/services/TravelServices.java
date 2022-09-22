package com.rachelsanchez.savetravels.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rachelsanchez.savetravels.models.Travel;
import com.rachelsanchez.savetravels.repositories.TravelRepository;

@Service
public class TravelServices {
	@Autowired
	private final TravelRepository travelRepository;

	public TravelServices(TravelRepository travelRepository) {
		this.travelRepository = travelRepository;
	}
	
	public List<Travel> allTravel() {
		return this.travelRepository.findAll();
	}

	public TravelRepository getTravelRepository() {
		return travelRepository;
	}
	
	public Travel createTravel(Travel t) {
		return travelRepository.save(t);
	}
	
	public Travel findTravel(Long id) {
	    Optional<Travel> optionalBook = (travelRepository).findById(id);
	      if(optionalBook.isPresent()) {
	          return optionalBook.get();
	      } else {
	          return null;
	      }
	}
	
}
