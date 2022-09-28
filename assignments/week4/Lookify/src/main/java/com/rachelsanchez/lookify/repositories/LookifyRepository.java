package com.rachelsanchez.lookify.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rachelsanchez.lookify.models.Lookify;

public interface LookifyRepository extends CrudRepository<Lookify, Long> {
	Lookify findByArtist(Lookify artist);
	Lookify findTop(Lookify rating);
}
