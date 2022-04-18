package com.codingdojo.dojosninjas.models;

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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="ninjas")
public class Ninja {
//	==============================ATTRIBUTES=============================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, max = 30, message="The first name must be no less than 2, and not over 30!")
    private String firstName;
    
    @NotNull
    @Size(min = 2, max = 30, message="The last name must be no less than 2, and not over 30!")
    private String lastName;
    
    @NotNull
    @Min(value= 1, message = "Must enter an age!")
    private Integer age;
    
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
//	=========================CONSTRUCTORS================================
	
	public Ninja() {
		super();
	}
	
	
	public Ninja(
			@NotNull @Size(min = 2, max = 30, message = "The first name must be no less than 2, and not over 30!") String firstName,
			@NotNull @Size(min = 2, max = 30, message = "The last name must be no less than 2, and not over 30!") String lastName,
			@NotNull @Min(value = 1, message = "Must enter an age!") Integer age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	
public Ninja(Long id,
			@NotNull @Size(min = 2, max = 30, message = "The first name must be no less than 2, and not over 30!") String firstName,
			@NotNull @Size(min = 2, max = 30, message = "The last name must be no less than 2, and not over 30!") String lastName,
			@NotNull @Min(value = 1, message = "Must enter an age!") Integer age, Date createdAt, Date updatedAt,
			Dojo dojo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.dojo = dojo;
	}


//	=======================GETTERS & SETTERS===============================

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
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
    protected void onCreate(){
        this.createdAt = new Date();
    }
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
