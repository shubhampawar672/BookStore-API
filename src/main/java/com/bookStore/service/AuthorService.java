package com.bookStore.service;

import java.util.List;

import com.bookStore.model.Author;

public interface AuthorService {
	
	boolean add(Author a);
	Author delete(Long id);
	Author update(Long id,Author author);
	Author get(Long id);
	List<String> getlist();

}
