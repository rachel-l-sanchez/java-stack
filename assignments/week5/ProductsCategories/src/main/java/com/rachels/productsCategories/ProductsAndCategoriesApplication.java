package com.rachels.productsCategories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class ProductsAndCategoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsAndCategoriesApplication.class, args);
	}

}
