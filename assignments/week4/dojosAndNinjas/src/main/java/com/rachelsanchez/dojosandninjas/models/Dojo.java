package com.rachelsanchez.dojosandninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="dojos")
public class Dojo {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotBlank
	    @NotEmpty
	    @Size(min=3)
	    private String name;
	    
//	   	cannot update created date
	    @Column(updatable= false)
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date createdAt;
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date updatedAt;
	    @OneToMany(mappedBy = "dojo",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	    private List<Ninja> ninjas;
	    
	    public Dojo() {
	        
	    }
	    

		public Dojo(Long id, @NotBlank @NotEmpty @Size(min = 3) String name, Date createdAt, Date updatedAt,
				List<Ninja> ninjas) {
			super();
			this.id = id;
			this.name = name;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.ninjas = ninjas;
		}


		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public String getName() {
			return name;
		}



		public void setName(String name) {
			this.name = name;
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



		public List<Ninja> getNinjas() {
			return ninjas;
		}



		public void setNinjas(List<Ninja> ninjas) {
			this.ninjas = ninjas;
		}



		@PrePersist
		protected void onCreate() {
			this.createdAt = new Date();
		}

		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}

		public String createDojo(Dojo dojo) {
			// TODO Auto-generated method stub
			return null;
		}

		public String createNinja(List<Ninja> ninja) {
			// TODO Auto-generated method stub
			return null;
		}

		public Dojo allDojosAndNinjas() {
			// TODO Auto-generated method stub
			return null;
		}

		public List<Dojo> allDojos(List<Dojo> dojos) {
			// TODO Auto-generated method stub
			return dojos;
		}

		public List<Dojo> findDojos(Long id) {
			// TODO Auto-generated method stub
			return null;
		}

}


