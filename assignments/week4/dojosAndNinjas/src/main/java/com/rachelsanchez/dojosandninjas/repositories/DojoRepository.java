package com.rachelsanchez.dojosandninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rachelsanchez.dojosandninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {


	Dojo save(Dojo dojo);
	List<Dojo> findAll();
	Optional<Dojo> findById(Long id);
	
}
