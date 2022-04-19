package com.codingdojo.belt.models;

import java.util.Date;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="plants")
public class Plant {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 2, message="The name must be no less than 2!")
    private String name;
    @NotNull
    @Size(min = 2, message="Must be at least 2 characters!")
    private String  schedule;
    
    @NotNull
    @Size(min = 2, message="The name must be no less than 2!")
    private String description;
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    private User user;


//=========================CONSTRUCTORS================================
	 
		public Plant() {
			super();
		}

		public Plant(@NotNull @Size(min = 2, message = "The name must be no less than 2!") String name,
				@NotNull @Size(min = 2, message = "Must be at least 2 characters!") String schedule,
				@NotNull @Size(min = 2, message = "The name must be no less than 2!") String description) {
			super();
			this.name = name;
			this.schedule = schedule;
			this.description = description;
		}

		public Plant(Long id, @NotNull @Size(min = 2, message = "The name must be no less than 2!") String name,
				@NotNull @Size(min = 2, message = "Must be at least 2 characters!") String schedule,
				@NotNull @Size(min = 2, message = "The name must be no less than 2!") String description, Date createdAt,
				Date updatedAt, User user) {
			super();
			this.id = id;
			this.name = name;
			this.schedule = schedule;
			this.description = description;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
			this.user = user;
		}

//=========================GETTERS & SETTERS================================
		
		
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

		public String getSchedule() {
			return schedule;
		}

		public void setSchedule(String schedule) {
			this.schedule = schedule;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
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

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
		 	 
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
		

}
