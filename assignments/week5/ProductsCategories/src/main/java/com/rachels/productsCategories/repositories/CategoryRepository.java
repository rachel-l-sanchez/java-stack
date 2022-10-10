package com.rachels.productsCategories.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rachels.productsCategories.models.Category;
import com.rachels.productsCategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long>{
	Category save(Category c);

    List<Category> findAllByProducts(Product product);
    
    // Retrieves a list of any categories a particular product
    // does not belong to.
    List<Category> findByProductsNotContains(Product product);
	List<Category> findAll();
	Optional<Category> findById(Long id);
}
