package com.bookStore.service;

import java.util.List;

import com.bookStore.model.Book;

public interface BookService {

	boolean add(Book b);
	Book update(Book b,Long id);
	Book getBookByTitle(String title);
	List<String> getBookTitles();
	
	boolean deleteBook(Long id);
	Book getBookById(Long id);
}
