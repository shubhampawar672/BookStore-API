package com.bookStore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookStore.model.Book;
import com.bookStore.respository.AuthorRepository;
import com.bookStore.service.AuthorServiceImpl;
import com.bookStore.service.BookAuthorServiceImpl;

@RestController
@RequestMapping("/bookauthor")
public class BookAuthorController {
	
	@Autowired
	private BookAuthorServiceImpl bookAuthorServiceImpl;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	//add book and author's association 
	@PostMapping("/add")
	public ResponseEntity<String>add(@RequestBody Map<String,Long>map)
	{
		Long bid=map.get("book_id");
		Long author_id=map.get("author_id");
		
		return bookAuthorServiceImpl.add(bid,author_id);
	}
	
	//select all books of a author by author id
	
	@GetMapping("/authorsbooks/{id}")
	public ResponseEntity<List<Book>> getBooks(@PathVariable(name="id") Long id)
	{
		List<Book> list=bookAuthorServiceImpl.getBooksByAuthorId(id);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	
	
	
	//select all books of a author by  author's first_name and last_name
	@GetMapping("/authorsbooksbyname/{fname}/{lname}")
	public ResponseEntity<List<Book>> getBooksByAuthorName(@PathVariable(name="fname") String fname,@PathVariable(name="lname") String lname)
	{
		Long id=authorRepository.findByFirstNameandLastName(fname,lname);
		List<Book> list=bookAuthorServiceImpl.getBooksByAuthorId(id);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	
	
	
	

}
