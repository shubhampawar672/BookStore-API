package com.bookStore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookStore.exception.AuthorNotFoundException;
import com.bookStore.model.Author;
import com.bookStore.model.Book;
import com.bookStore.model.Book_Author;
import com.bookStore.respository.AuthorRepository;
import com.bookStore.respository.BookAuthorRepository;
import com.bookStore.respository.BookRepository;

@Service
public class BookAuthorServiceImpl implements BookAuthorService{
	@Autowired
	private BookAuthorRepository bookAuthorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	//add book and author association  
	public ResponseEntity<String> add(Long bid, Long author_id) {
		
		Optional<Book>book=bookRepository.findById(bid);
		
		Optional<Author>author=authorRepository.findById(author_id);
		
		if(book.isEmpty() || author.isEmpty())
		{
			new ResponseEntity<>("Book or Author not found.",HttpStatus.NOT_FOUND);
		}
		
		if(bookAuthorRepository.findByBookAndAuthor(book.get(),author.get()).isPresent())
		{
			return new  ResponseEntity<>("Book-Author association is already present",HttpStatus.BAD_REQUEST);
		}
		
		Book_Author bookauthor=new Book_Author();
		
		bookauthor.setAuthor(author.get());
		bookauthor.setBook(book.get());
		bookAuthorRepository.save(bookauthor);
		
		return new ResponseEntity<>("Book-Author association established",HttpStatus.CREATED);
	}

	//select all books of a author by author id
	public List<Book> getBooksByAuthorId(Long id) throws AuthorNotFoundException {
		
		List<Long>list= bookAuthorRepository.findBookByAuthorId(id);
		if(list.isEmpty())
		{
			throw new AuthorNotFoundException("Author with id "+id+" not found.");
		}else
		{
			List<Book>lst=new ArrayList<>();
			for(int i=0;i<list.size();i++)
			{
				Book b=bookServiceImpl.getBookById(list.get(i));
				lst.add(b);
			}
			return lst;
		}
	}
	
	
}
