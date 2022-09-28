package com.rachelsanchez.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rachelsanchez.savetravels.models.Travel;

@Repository
public interface ExpenseRepository extends CrudRepository<Travel, Long> {
	List<Travel> findAll();
//	this method finds by the description of the expense
	List<Travel> findByDescriptionContaining(String search);
//	this method finds by the expense amount
	Long countByExpenseContaining(int amount);
}
