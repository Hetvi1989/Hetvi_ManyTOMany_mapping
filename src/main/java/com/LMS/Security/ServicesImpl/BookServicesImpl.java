package com.LMS.Security.ServicesImpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.Security.Entity.Book;
import com.LMS.Security.Repository.BookJpaRepository;
import com.LMS.Security.Services.BookServices;
@Service
public class BookServicesImpl implements BookServices {
	
	@Autowired
	private BookJpaRepository bookRepository; 

	@Override
	public Set<Book> findAll() {
		
		return Set.copyOf(this.bookRepository.findAll());
	}

	@Override
	public Book findByID(int Id) {
		
		return this.bookRepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("Invalid book id passed"));
	}

	@Override
	public Book save(Book book) {
		
		return this.bookRepository.save(book);
	}

	@Override
	public void deleteById(int id) {
		
		this.bookRepository.deleteById(id);
	
	}

	@Override
	public Set<Book> searchBook(String name, String author) {
		
		return this.bookRepository.findByNameContainsAndAuthorContainsAllIgnoreCase(name, author);
	}

}
