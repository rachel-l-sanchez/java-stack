package com.rachels.productsCategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rachels.productsCategories.models.Category;
import com.rachels.productsCategories.models.Product;
import com.rachels.productsCategories.repositories.ProductRepository;


@Service
public class ProductService {

		@Autowired
		private ProductRepository productRepository;
		
		public ProductRepository getProductRepository() {
			return productRepository;
		}

		public void setProductRepository(ProductRepository productRepository) {
			this.productRepository = productRepository;
		}

		public ProductService(ProductRepository productRepository) {
			super();
			this.productRepository = productRepository;
		}

		public ProductService() {
			
		}
		
		public Product getOne(Long id) {
			Optional<Product> oneProduct = productRepository.findById(id);
			if (oneProduct.isPresent()) {
				return oneProduct.get();
			}
			else {
				return null;
			}
		}
		
//		add a product
		public Product create(Product p) {
			return productRepository.save(p);
		}
		
//		find a category of a certain type of product using a list to see if it's inside the list
//		if not add to the list
		public List<Product> find() {
			return productRepository.findAll();
		}
		
		
//		find all products with the category passed in
//		list is non inclusive of the parameter
		public List<Product> findByCategory(Category categoryName) {
			if (categoryName != null) {
				return  productRepository.findByCategoriesNotContains(categoryName);
			}
			else {
				return null;
			}

		}
		
		public List<Product> findAllBy(Category category) {
			return productRepository.findAllByCategories(category);
		}
		
//		create the many to many relationship with products and categories by adding to the list
		public Product addProduct(Product newProduct, Category categoryName) {
			// TODO Auto-generated method stub
			
			newProduct.getCategories().add(categoryName);
			return productRepository.save(newProduct);

		}
		
//		update a product entry
		
		public Product updateOne(Product product) {
			return productRepository.save(product);
		}
		
		public void destroy(Long id) {
			productRepository.deleteById(id);
		}
	}

