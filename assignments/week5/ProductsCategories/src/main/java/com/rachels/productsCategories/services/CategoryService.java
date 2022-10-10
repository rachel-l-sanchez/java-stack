package com.rachels.productsCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rachels.productsCategories.models.Category;
import com.rachels.productsCategories.models.Product;
import com.rachels.productsCategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepo;
	
	public CategoryService(CategoryRepository cRepo) {
		super();
		this.cRepo = cRepo;
	}
	
	public CategoryService() {
		
	}
		
	public CategoryRepository getcRepo() {
		return cRepo;
	}

	public void setcRepo(CategoryRepository cRepo) {
		this.cRepo = cRepo;
	}

	public Iterable<Category> getAll() {
		return cRepo.findAll();
	}
		
			
	public Category create(Category c) {
		return cRepo.save(c);
	}

	public List<Category> find() {
		return cRepo.findAll();
	}
	
	
//	find a category for one product
	public List<Category> findByProduct(Product product) {
		if (product != null) {
			return  cRepo.findByProductsNotContains(product);
		}
		else {
			return null;
		}

	}
	
//	find all categories for a product
	public List<Category> findAllBy(Product product) {
		return cRepo.findAllByProducts(product);
	}

	public Category addCategory(Product newProduct, Category categoryName) {
		// TODO Auto-generated method stub
		categoryName.getProducts().add(newProduct);
		return cRepo.save(categoryName);
	}
	
	public Category findById(Long id) {
		Optional<Category> category = cRepo.findById(id);
		if (category.isPresent()) {
				return category.get();
		}
		return null;
		
	}
}
