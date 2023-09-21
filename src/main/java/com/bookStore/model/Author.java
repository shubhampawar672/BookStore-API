package com.bookStore.model;

import java.sql.Date;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Author")
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long author_id;
	
	@NotBlank(message="first_name is required")
	private String first_name;
	@NotBlank(message="last_name is required")
	private String last_name;
	
	@NotBlank(message="birth_date is required")
	private Date birth_date;
	
	@NotBlank(message="biography is required")
	@Column(length=500)
	private String biography;

	public Author(Long author_id, String first_name, String last_name, Date birth_date, String biography) {
		super();
		this.author_id = author_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.birth_date = birth_date;
		this.biography = biography;
	}

	public Long getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(Long author_id) {
		this.author_id = author_id;
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

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public Author() {
		super();
	}
	
	
	

}
