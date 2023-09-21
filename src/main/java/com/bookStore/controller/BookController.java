package com.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookStore.exception.BookNotFoundException;
import com.bookStore.model.Book;
import com.bookStore.respository.AuthorRepository;
import com.bookStore.respository.BookRepository;
import com.bookStore.service.BookServiceImpl;
import com.bookStore.respository.BookAuthorRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/BookStore")
public class BookController {
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	@GetMapping("/greet")
	public String greetings()
	{
		System.out.println("Hello");
		return "Starting Book Store";
	}
	
	//Add new book 
	@PostMapping("/addbook")
	public ResponseEntity<Boolean> addBook(@RequestBody Book book)
	{
		boolean b=bookServiceImpl.add(book);
		return ResponseEntity.ok(b);
	}
	
	
	//Update Existing Book
	@PutMapping("/updatebook/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable(name="id") Long id)
	{
		
//If global exception handling is  not in place then following code else following it
//		Book b;
//		try {
//			b = bookServiceImpl.update(book,id);
//			return new ResponseEntity<>(b,HttpStatus.OK);
//		} catch (BookNotFoundException e) {
//
//			e.printStackTrace();
//			return ResponseEntity.notFound().build();
//			
//		}
		
		
	    Book b = bookServiceImpl.update(book, id);
	    return new ResponseEntity<>(b, HttpStatus.OK);
		
	}
	
	//Get book details by id
	@GetMapping("/getbookbyid/{id}")
	public  ResponseEntity<Book> getBook(@PathVariable(name="id") Long id)
	{
		Book book=bookServiceImpl.getBookById(id);
		
		return new ResponseEntity<>(book,HttpStatus.OK);
	}
	//Get book details by title
	@GetMapping("/getbook/{title}")
	public ResponseEntity<Book> getBook(@PathVariable(name="title") String title)
	{
		Book book=bookServiceImpl.getBookByTitle(title);
		
		return new ResponseEntity<>(book,HttpStatus.OK);
	}
	
	//Get all Book's Title list
	@GetMapping("/booktitles")
	public ResponseEntity<List<String>> getBookTitles()
	{
		List<String> list=bookServiceImpl.getBookTitles();
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
		
	}
	
	
	//Delete book by id
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Boolean> deleteBook(@PathVariable(name="id") Long id)
	{
		bookServiceImpl.deleteBook(id);
		return new ResponseEntity<>(true,HttpStatus.OK);
		
	}

}
