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

import com.bookStore.model.Author;
import com.bookStore.service.AuthorService;
import com.bookStore.service.AuthorServiceImpl;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Author")
public class AuthorController {
	
	@Autowired
	private AuthorServiceImpl authorServiceImpl;
	
	
	//Add author
	@PostMapping("/addauthor")
	public ResponseEntity<Boolean> add(@RequestBody Author author)
	{
		boolean b=authorServiceImpl.add(author);
		
		return new ResponseEntity<>(b,HttpStatus.OK);	
	}
	
	
	//delete author by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Author> delete(@PathVariable(name="id") Long id)
	{
		Author author=authorServiceImpl.delete(id);
		
		return new ResponseEntity<>(author,HttpStatus.OK);
	}
	
	//Update author by id
	@PutMapping("/update/{id}")
	public ResponseEntity<Author> update(@RequestBody Author author,@PathVariable(name="id") Long id)
	{
		Author a=authorServiceImpl.update(id,author);
		return new ResponseEntity<>(a,HttpStatus.OK);
	}
	
	//Get Author details by id
	@GetMapping("/getauthor/{id}")
	public ResponseEntity<Author> get(@PathVariable(name="id") Long id)
	{
		Author a=authorServiceImpl.get(id);
		
		return new ResponseEntity<>(a,HttpStatus.FOUND);
	}
	
	//Get all author list with first name and last name
	@GetMapping("/getlist")
	public List<String> getlist()
	{
		List<String>list=authorServiceImpl.getlist();
		return list;
	}
	

}
