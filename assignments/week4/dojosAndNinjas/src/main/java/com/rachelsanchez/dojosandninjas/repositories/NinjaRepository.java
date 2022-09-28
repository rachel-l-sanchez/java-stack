package com.rachelsanchez.dojosandninjas.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rachelsanchez.dojosandninjas.models.Ninja;
	public interface NinjaRepository extends CrudRepository<Ninja, Long> {

		Ninja save(Ninja ninja);

}
