package com.bookStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.bookStore.model.Book;
import com.bookStore.model.Book_Author;

public interface BookAuthorService {
	
	ResponseEntity<String> add(Long bid, Long author_id) ;
	List<Book> getBooksByAuthorId(Long id);

}
