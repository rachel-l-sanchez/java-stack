package com.rachelsanchez.savetravels.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rachelsanchez.savetravels.models.Travel;

@Repository
public interface ExpenseRepository extends CrudRepository<Travel, Long> {
	List<Travel> findAll();
	 // this method finds books with descriptions containing the search string
	List<Travel> findByDescriptionContaining(String search);
	 // this method counts how many titles contain a certain string
	Long countByExpenseContaining(String search);
	 // this method deletes a book that starts with a specific title
	Long deleteByIdStartingWith(Long id);
}
