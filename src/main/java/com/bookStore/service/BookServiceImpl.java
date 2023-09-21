package com.bookStore.service;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookStore.exception.BookNotFoundException;
import com.bookStore.model.Book;
import com.bookStore.respository.AuthorRepository;
import com.bookStore.respository.BookAuthorRepository;
import com.bookStore.respository.BookRepository;

@Service
public class BookServiceImpl {
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookAuthorRepository bookAuthorRepository;
	
	//Add new book
	public boolean add(Book b)
	{
		Book book=bookRepository.save(b);
		if(book==null)
			return false;
		else
			return true;
	}
	
	
	//Update Book
	public Book update(Book b,Long id) throws BookNotFoundException
	{
		Optional<Book> b1=bookRepository.findById(id);
		
		if(b1.isPresent())
		{
			Book book=b1.get();
			book.setDescription(b.getDescription());
			book.setGenere(b.getGenere());
			book.setIsbn(b.getIsbn());
			book.setPrice(b.getPrice());
			book.setTitle(b.getTitle());
			book.setYear(b.getYear());
			bookRepository.save(book);
			return book;
			
		}else
		{
			throw new BookNotFoundException("Book with id "+id+" not found");
		}
	}
	
	
	//Get book details by book title 
	public Book getBookByTitle(String title) throws BookNotFoundException
	{
		Optional<Book> book=Optional.ofNullable((bookRepository.findByTitle(title)));
		
		if(book.isPresent())
		{
			return book.get();
		}else
		{
			throw new BookNotFoundException("Book with title '"+title+"' not found");
		}
	}
	
	//Get all Book's Title list
	public List<String> getBookTitles()
	{
		return bookRepository.findTitlesBy();

	}
	
	public boolean deleteBook(Long id)
	{
		Optional<Book>book=bookRepository.findById(id);
		
		if(book.isPresent())
		{
			bookAuthorRepository.deleteByBookId(id);
			bookRepository.deleteById(id);
			
			return true;
			
		}else
		{
			throw new BookNotFoundException("Book with id "+id+" not found.");
		}
	}
	
	public Book getBookById(Long id)
	{
		Optional<Book> book=bookRepository.findById(id);
		if(book.isPresent())
		{
			return book.get();
		}
		else {
			throw new BookNotFoundException("Book with id "+id+" not found.");
		}
	}
	

}
