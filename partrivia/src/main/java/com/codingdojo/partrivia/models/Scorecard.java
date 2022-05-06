package com.codingdojo.partrivia.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="scorecards")
public class Scorecard {
  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
  @NotNull
  @Max(value = 8, message = "Hole ends at double par!")
  private Integer score;
  
  @NotNull
  @Max(value = 24, message = "")
  private Integer total;
  
  @Column(updatable=false)
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date createdAt;
  
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date updatedAt;
	
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="user_id")
  private User user;

public Scorecard() {
	super();
}

public Scorecard(@NotNull @Max(value = 8, message = "Hole ends at double par!") Integer score,
		@NotNull @Max(value = 24, message = "") Integer total) {
	super();
	this.score = score;
	this.total = total;
}

public Scorecard(Long id, @NotNull @Max(value = 8, message = "Hole ends at double par!") Integer score,
		@NotNull @Max(value = 24, message = "") Integer total, Date createdAt, Date updatedAt, User user) {
	super();
	this.id = id;
	this.score = score;
	this.total = total;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.user = user;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Integer getScore() {
	return score;
}

public void setScore(Integer score) {
	this.score = score;
}

public Integer getTotal() {
	return total;
}

public void setTotal(Integer total) {
	this.total = total;
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

  
}
