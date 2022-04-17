package com.codingdojo.savetravels.models;

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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 30, message="The name must be no less than 3, and not over 30!")
    private String name;
    @NotNull
    @Size(min = 2, max = 30, message="You must include the vendor!")
    private String  vendor;
    
    @NotNull
    @Min(value= 0, message = "Must be higher than $0")
//    @Max(value=, message = "Must be rating 10 or lower")
    private Double amount;
    
    @NotNull
    @Size(min = 1, max = 100, message="You must add a description!")
    private String  description;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	
	
	public Expense() {
		super();
	}
	
	
	public Expense(
			@NotNull @Size(min = 3, max = 30, message = "The name must be no less than 3, and not over 30!") String name,
			@NotNull @Size(min = 2, max = 30, message = "You must include the vendor!") String vendor,
			@NotNull @Min(value = 0, message = "Must be higher than $0") @NotNull @Min(value = 0, message = "Must be higher than $0") Double amount, @NotNull @Size(min = 1, max = 300, message = "You must add a description!") String description) {
		super();
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
	}

	

	public Expense(Long id,
			@NotNull @Size(min = 3, max = 30, message = "The name must be no less than 3, and not over 30!") String name,
			@NotNull @Size(min = 2, max = 30, message = "You must include the vendor!") String vendor,
			@NotNull @Min(value = 0, message = "Must be higher than $0") @NotNull @Min(value = 0, message = "Must be higher than $0") Double amount, Date createdAt,
			Date updatedAt, @NotNull @Size(min = 1, max = 300, message = "You must add a description!") String description) {
		super();
		this.id = id;
		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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


	public String getVendor() {
		return vendor;
	}


	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public @NotNull @Min(value = 0, message = "Must be higher than $0") Double getAmount() {
		return amount;
	}


	public void setAmount(@NotNull @Min(value = 0, message = "Must be higher than $0") Double amount) {
		this.amount = amount;
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


	// other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}