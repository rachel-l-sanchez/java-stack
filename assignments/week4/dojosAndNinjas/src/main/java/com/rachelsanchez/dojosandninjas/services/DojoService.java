package com.rachelsanchez.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rachelsanchez.dojosandninjas.models.Dojo;
import com.rachelsanchez.dojosandninjas.models.Ninja;
import com.rachelsanchez.dojosandninjas.repositories.DojoRepository;
import com.rachelsanchez.dojosandninjas.repositories.NinjaRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dojoRepository;
	private NinjaRepository ninjaRepository;
	
	
//	fetch all dojo and ninja attributes
	
	public List<Dojo> allDojosAndNinjas() {
		return (List<Dojo>) this.dojoRepository.findAll();
	}

	public Dojo findDojos(Long id) {
	  Optional<Dojo> optionalDojo = dojoRepository.findById(id);
	  if(optionalDojo.isPresent()) {
	       return optionalDojo.get();
	  } else {
	       return null;
	       }
	  }
	public DojoRepository getDojoRepository() {
		return dojoRepository;
	}

	public void setDojoRepository(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
//	create ninjas and dojos
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo); 
	}
	
	public DojoService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
		super();
		this.dojoRepository = dojoRepository;
		this.ninjaRepository = ninjaRepository;
	}

	public Ninja createNinja(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}

	public NinjaRepository getNinjaRepository() {
		return ninjaRepository;
	}

	public void setNinjaRepository(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}



}
