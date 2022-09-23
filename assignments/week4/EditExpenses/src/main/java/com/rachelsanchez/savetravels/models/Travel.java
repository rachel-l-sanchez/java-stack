package com.rachelsanchez.savetravels.models;

import java.util.Date;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "travel")
public class Travel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Size should be greater than 0")
	@Min(1)
	private Integer amount;
	@NotNull(message = "Must not be blank")
	@NotEmpty
	@NotBlank
	@Size(min=3, max=40)
	private String expense;
	
	@NotNull(message = "Must not be blank")
	@NotBlank
	@NotEmpty
	@Size(min=3, max=40)
	private String vendor;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@NotNull(message = "Must not be blank")
	@NotBlank
	@NotEmpty
	@Size(min=5, max=100)
	private String description;
	

	
	public Travel(Long id, @NotNull(message = "Size should be greater than 0") @Min(1) Integer amount,
			@NotNull(message = "Must not be blank") @NotEmpty @NotBlank @Size(min = 3, max = 40) String expense,
			@NotNull(message = "Must not be blank") @NotBlank @NotEmpty @Size(min = 3, max = 40) String vendor,
			Date createdAt, Date updatedAt,
			@NotNull(message = "Must not be blank") @NotBlank @NotEmpty @Size(min = 5, max = 100) String description) {
		this.id = id;
		this.amount = amount;
		this.expense = expense;
		this.vendor = vendor;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.description = description;
	}

	public  Travel() {
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	public Optional<Travel> get() {
		// TODO Auto-generated method stub
		return null;
	}

	public String setExpense(@Valid Travel travel) {
		// TODO Auto-generated method stub
		return expense;
	}


	public void setVendor(@Valid Travel travel) {
		// TODO Auto-generated method stub
		
	}

	public void setDescription(@Valid Travel travel) {
		// TODO Auto-generated method stub
		
	}


	public void setAmount(@Valid Travel travel) {
		// TODO Auto-generated method stub
		
	}

	public void setUpdatedAt(@Valid Travel travel) {
		// TODO Auto-generated method stub
		
	}

	public Travel findExpense(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	

}
