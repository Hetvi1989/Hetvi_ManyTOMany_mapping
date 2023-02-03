package com.LMS.Security.Controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.Security.Entity.Book;
import com.LMS.Security.Services.BookServices;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookServices boookServices;
	
	@GetMapping
	public Set <Book> fetchBook(){
		return this.boookServices.findAll();
	}
	
	@GetMapping("/{id}")
	public Book findBookById(@PathVariable("id") int id) {
		return this.boookServices.findByID(id);
	}
	
	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		return this.boookServices.save(book);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		this.boookServices.deleteById(id); 
		
	}
}
