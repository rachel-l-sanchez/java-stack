package com.rachels.productsCategories.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rachels.productsCategories.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	User save(User user);
	Iterable<User> findAll();
	Optional<User> findByEmail(String email);
	Optional<User> findById(Long id);
	String findByName(String name);
}
