package com.bookStore.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bookStore.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	public Book findByTitle(String title);
	
	@Query(value="select title from book",nativeQuery=true)
	public List<String> findTitlesBy();
}
