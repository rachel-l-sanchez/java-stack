package com.rachels.productsCategories.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rachels.productsCategories.models.Category;
import com.rachels.productsCategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	Product save(Product p);
	// Retrieves a list of all products for a particular category
    List<Product> findAllByCategories(Category category);    
    // Retrieves a list of any products a particular category
    // does not belong to.
    List<Product> findByCategoriesNotContains(Category category);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Long id);

}
