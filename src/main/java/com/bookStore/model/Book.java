package com.bookStore.model;

import java.sql.Date;

import org.hibernate.validator.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long book_id;
	
	@NotBlank(message="Title is required")
	private String title;
	
	@NotBlank(message="genere is required")
	private String genere;
	
	@NotBlank(message="price is required")
	private float price;
	
	@NotBlank(message="isbn is required")
	@Column(unique = true)
	private String isbn;
	
	@NotBlank(message="Year is required")
	private int Year;
	
	@Column(length=1000)
	private String description;
	
	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public Book() {
		super();
	}

	public Book(Long book_id, String title, String genere, float price, String isbn, String description, int year) {
		super();
		this.book_id = book_id;
		this.title = title;
		this.genere = genere;
		this.price = price;
		this.isbn = isbn;
		this.description = description;
		Year = year;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	
	
	

}
