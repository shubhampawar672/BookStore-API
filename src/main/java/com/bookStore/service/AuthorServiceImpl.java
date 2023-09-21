
package com.bookStore.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.exception.AuthorNotFoundException;
import com.bookStore.model.Author;
import com.bookStore.respository.AuthorRepository;
import com.bookStore.respository.BookAuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService{
	@Autowired
	private AuthorRepository  authorRepository;
	@Autowired
	private BookAuthorRepository bookAuthorRepository;
	
	public boolean add(Author a)
	{
		Author author=authorRepository.save(a);
		if(author!=null)
		return true;
		return false;
	}

	public Author delete(Long id) {
		
		Optional<Author>author=authorRepository.findById(id);
		
		if(author.isPresent())
		{
			bookAuthorRepository.deleteByAuthorId(id);
			authorRepository.deleteById(id);
			return author.get();
		}
		else
		{
			throw new AuthorNotFoundException("Author with id "+id+" not found.");
		}
	}

	public Author update(Long id,Author author) {
			
		Optional<Author>a=authorRepository.findById(id);
		
		if(a.isPresent())
		{
			Author authorU= a.get();
			authorU.setBiography(author.getBiography());
			authorU.setBirth_date(author.getBirth_date());
			authorU.setFirst_name(author.getFirst_name());
			authorU.setLast_name(author.getLast_name());
			
			authorRepository.save(authorU);
			return authorU;
		}
		else
		{
			throw new AuthorNotFoundException("Author with id "+id+" not found.");
		}
	}

	public Author get(Long id) {
		
		Optional<Author>author=authorRepository.findById(id);
		
		if(author.isPresent())
		{
			return author.get();
		}else
		{
			throw new AuthorNotFoundException("Author with id "+id+" not found.");
		}
	}

	public List<String> getlist() {
		
		return authorRepository.findFisrtNameLastName();
	}
	
	
}
