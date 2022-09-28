package com.rachelsanchez.dojosandninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ninjas")
public class Ninja {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	@NotBlank
	@NotEmpty
	@Column(name = "first_name")
	@Size(min=3)
    private String first_name;
	
	@NotBlank
	@NotEmpty
	@Column(name = "last_name")
	@Size(min=3)
    private String last_name;
	
	@NotNull(message = "The value must be at least 1")
	@Column(name = "age")
	@Min(1)
    private int age;
    
//    a created date that doesn't change
    @Column(name = "createdAt", updatable=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "updatedAt")
    private Date updatedAt;
    
//    many side of the relationship. Many ninjas for one dojo
    @ManyToOne(fetch=FetchType.LAZY)
    @NotNull
    @JoinColumn(name="dojo_id")
    private Dojo dojo;

    
    public Ninja() {
        
    }

    
	
	public Ninja(Long id, @NotBlank @NotEmpty @Size(min = 3) String first_name,
			@NotBlank @NotEmpty @Size(min = 3) String last_name,
			@NotNull(message = "The value must be at least 1") @Min(1) int age, Date createdAt, Date updatedAt,
			@NotNull Dojo dojo) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.dojo = dojo;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirst_name() {
		return first_name;
	}



	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}



	public String getLast_name() {
		return last_name;
	}



	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
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



	public Dojo getDojo() {
		return dojo;
	}



	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}



	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	public String createNinja(Ninja ninja) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
