package com.rachels.productsCategories.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.rachels.productsCategories.models.Category;

@Entity
@Table(name = "products")

public class Product {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id", nullable= false)
		private Long id;
		
		@NotEmpty(message = "product name must not be blank")
		@NotBlank
		@Size(min = 3, message = "Length must be at least 3 characters")
		private String productName;
		
		@NotEmpty(message = "description must not be blank")
		@NotBlank
		@Size(min = 3, message = "description must be at least 3 characters")
		private String description;
		
		@NotNull
		@Min(1)
		private Long price;
		
		@Column(updatable = false)
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date createdAt;
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date updatedAt;
		
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(
		        name = "categories_products", 
		        joinColumns = @JoinColumn(name = "product_id"), 
		        inverseJoinColumns = @JoinColumn(name = "category_id")
		)
		private List<Category> categories;

		public Product(Long id,
				@NotEmpty(message = "product name must not be blank") @NotBlank @Size(min = 3, message = "Length must be at least 3 characters") String productName,
				@NotNull @Min(1) Long price, Date createdAt, Date updatedAt, List<Category> categories) {
			super();
			this.id = id;
			this.productName = productName;
			this.price = price;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.categories = categories;
		}
		
		public Product() {
			
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		public Long getPrice() {
			return price;
		}

		public void setPrice(Long price) {
			this.price = price;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public List<Category> getCategories() {
			return categories;
		}

		public void setCategories(List<Category> categories) {
			this.categories = categories;
		}
		
		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}
		@PreUpdate
		protected void onUpdate() {
			this.createdAt = new Date();
		}
}